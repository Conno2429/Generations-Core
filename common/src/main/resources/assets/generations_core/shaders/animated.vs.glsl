#version 330 core
#define MAX_BONES 220

layout(location = 0) in vec3 positions;
layout(location = 1) in vec2 texcoords;
layout(location = 2) in vec3 inNormal;
layout(location = 3) in vec4 joints;
layout(location = 4) in vec4 weights;

out float vertexDistance;
out vec4 vertexColor;
out vec2 texCoord0;

uniform int FogShape;

uniform mat4 viewMatrix;
uniform mat4 modelMatrix;
uniform mat4 projectionMatrix;
uniform vec2 uvOffset;
uniform vec2 uvScale;

uniform vec3 Light0_Direction;
uniform vec3 Light1_Direction;

uniform mat4 boneTransforms[MAX_BONES];

mat4 getBoneTransform() {
    mat4 boneTransform =
    boneTransforms[uint(joints.x)] * weights.x + // Bone 1 Transform (Bone Transform * Weight)
    boneTransforms[uint(joints.y)] * weights.y + // Bone 2 Transform (Bone Transform * Weight)
    boneTransforms[uint(joints.z)] * weights.z + // Bone 3 Transform (Bone Transform * Weight)
    boneTransforms[uint(joints.w)] * weights.w ; // Bone 4 Transform (Bone Transform * Weight)
    return boneTransform;
}

float fog_distance(mat4 modelViewMat, vec3 pos, int shape) {
    if (shape == 0) {
        return length((modelViewMat * vec4(pos, 1.0)).xyz);
    } else {
        float distXZ = length((modelViewMat * vec4(pos.x, 0.0, pos.z, 1.0)).xyz);
        float distY = length((modelViewMat * vec4(0.0, pos.y, 0.0, 1.0)).xyz);
        return max(distXZ, distY);
    }
}

#vert

void main() {
    mat4 worldSpace = projectionMatrix * viewMatrix;
    mat4 modelTransform = modelMatrix * getBoneTransform();
    vec4 worldPosition = modelTransform * vec4(positions, 1.0);

    texCoord0 = (texcoords * uvScale) + uvOffset;
    gl_Position = worldSpace * worldPosition;
    vertexDistance = fog_distance(worldSpace * modelTransform, positions, FogShape);
    vertexColor = getVertexColor(Light0_Direction, Light1_Direction, inNormal);
}