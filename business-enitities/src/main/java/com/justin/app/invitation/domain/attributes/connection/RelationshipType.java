package com.justin.app.invitation.domain.attributes.connection;

public enum RelationshipType {


    FRIEND {
        @Override
        RelationshipType inverse() {
            return FRIEND;
        }
    },
    CLIENT {
        @Override
        RelationshipType inverse() {
            return CLIENTELE;
        }
    },
    CLIENTELE {
        @Override
        RelationshipType inverse() {
            return PATIENT;
        }
    },
    DOCTOR {
        @Override
        RelationshipType inverse() {
            return CLIENT;
        }
    },

    PATIENT {
        @Override
        RelationshipType inverse() {
            return DOCTOR;
        }
    },
    EMPLOYER {
        @Override
        RelationshipType inverse() {
            return EMPLOYEE;
        }
    },
    EMPLOYEE {
        @Override
        RelationshipType inverse() {
            return EMPLOYER;
        }
    },
    CHILD_FATHER {
        @Override
        RelationshipType inverse() {
            return PARENT_FATHER;
        }
    },
    PARENT_FATHER {
        @Override
        RelationshipType inverse() {
            return CHILD_FATHER;
        }
    },
    CHILD_MOTHER {
        @Override
        RelationshipType inverse() {
            return PARENT_MOTHER;
        }
    },
    PARENT_MOTHER {
        @Override
        RelationshipType inverse() {
            return CHILD_MOTHER;
        }
    },
    COLLEAGUE {
        @Override
        RelationshipType inverse() {
            return COLLEAGUE;
        }
    };

    abstract RelationshipType inverse();
}
