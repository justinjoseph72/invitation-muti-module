package com.justin.app.invitation.domain;

import com.google.common.base.Objects;
import com.justin.app.invitation.domain.attributes.connection.RelationshipStatus;
import com.justin.app.invitation.domain.attributes.connection.RelationshipType;
import lombok.Getter;

import java.math.BigInteger;
import java.time.Clock;
import java.time.LocalDateTime;

@Getter
public final class Connection {

    private final BigInteger connectionId;
    private final Person fromPerson;
    private final Person toPerson;
    private final RelationshipType type;
    private final RelationshipStatus status;
    private final LocalDateTime invitedAt;
    private final LocalDateTime acceptedAt;
    private final LocalDateTime rejectedAt;
    private final LocalDateTime archivedAt;


    private Connection(BigInteger connectionId, Person fromPerson, Person toPerson, RelationshipType type, RelationshipStatus status, LocalDateTime invitedAt, LocalDateTime acceptedAt, LocalDateTime rejectedAt, LocalDateTime archivedAt) {
        this.connectionId = connectionId;
        this.archivedAt = archivedAt;
        this.acceptedAt = acceptedAt;
        this.rejectedAt = rejectedAt;
        this.status = status;
        this.toPerson = toPerson;
        this.fromPerson = fromPerson;
        this.type = type;
        this.invitedAt = invitedAt;
    }

    public static Connection.ConnectionBuilder builder() {
        return new ConnectionBuilder();
    }

    public static class ConnectionBuilder {
        private BigInteger connectionId;
        private Person fromPerson;
        private Person toPerson;
        private RelationshipType type;
        private RelationshipStatus status;
        private LocalDateTime invitedAt;
        private LocalDateTime acceptedAt;
        private LocalDateTime rejectedAt;
        private LocalDateTime archivedAt;

        public ConnectionBuilder() {

        }

        public Connection.ConnectionBuilder connectionId(final BigInteger connectionId) {
            this.connectionId = connectionId;
            return this;
        }

        public Connection.ConnectionBuilder fromPerson(final Person fromPerson) {
            this.fromPerson = fromPerson;
            return this;
        }

        public Connection.ConnectionBuilder toPerson(final Person toPerson) {
            this.toPerson = toPerson;
            return this;
        }

        public Connection.ConnectionBuilder type(final RelationshipType type) {
            this.type = type;
            return this;
        }

        public Connection.ConnectionBuilder status(final RelationshipStatus status) {
            this.status = status;
            return this;
        }

        public Connection.ConnectionBuilder invitedAt(final LocalDateTime invitedAt) {
            this.invitedAt = invitedAt;
            return this;
        }

        public Connection.ConnectionBuilder acceptedAt(final LocalDateTime acceptedAt) {
            this.acceptedAt = acceptedAt;
            return this;
        }

        public Connection.ConnectionBuilder rejectedAt(final LocalDateTime rejectedAt) {
            this.rejectedAt = rejectedAt;
            return this;
        }

        public Connection.ConnectionBuilder archivedAt(final LocalDateTime archivedAt) {
            this.archivedAt = archivedAt;
            return this;
        }


        public Connection build() {
            return new Connection(this.connectionId, this.fromPerson, this.toPerson, this.type, this.status, this.invitedAt, this.acceptedAt, this.rejectedAt, this.archivedAt);
        }

        public String toString() {
            return "Connection.ConnectionBuilder(connectionId=" + this.connectionId + ", fromPerson=" + this.fromPerson + ", toPerson=" + this.toPerson + ", type=" + this.type + ", status=" + this.status + ", invitedAt=" + this.invitedAt + ", acceptedAt=" + this.acceptedAt + ", rejectedAt=" + this.rejectedAt + ", archivedAt=" + this.archivedAt + ")";
        }
    }

    public Connection acceptConnection(Clock clock) {
        LocalDateTime newDate = LocalDateTime.from(clock.instant());
        return Connection.builder().connectionId(this.connectionId)
                .fromPerson(this.fromPerson).toPerson(this.toPerson)
                .acceptedAt(newDate).archivedAt(this.archivedAt).rejectedAt(this.rejectedAt).invitedAt(this.invitedAt)
                .type(this.type).status(RelationshipStatus.APPROVED)
                .build();
    }

    public Connection rejectConnection(Clock clock) {
        LocalDateTime newDate = LocalDateTime.from(clock.instant());
        return Connection.builder().connectionId(this.connectionId)
                .fromPerson(this.fromPerson).toPerson(this.toPerson)
                .acceptedAt(this.acceptedAt).archivedAt(this.archivedAt).rejectedAt(newDate).invitedAt(this.invitedAt)
                .type(this.type).status(RelationshipStatus.REJECTED)
                .build();
    }

    public Connection archiveConnection(Clock clock) {
        LocalDateTime newDate = LocalDateTime.from(clock.instant());
        return Connection.builder().connectionId(this.connectionId)
                .fromPerson(this.fromPerson).toPerson(this.toPerson)
                .acceptedAt(this.acceptedAt).archivedAt(newDate).rejectedAt(this.rejectedAt).invitedAt(this.invitedAt)
                .type(this.type).status(RelationshipStatus.ARCHIVED)
                .build();
    }

    public static Connection createPendingConnection(Person fromPerson, Person toPerson, RelationshipType type, Clock clock){
        LocalDateTime invitedDate = LocalDateTime.from(clock.instant());
        return Connection.builder().invitedAt(invitedDate)
                .fromPerson(fromPerson).toPerson(toPerson)
                .type(type).status(RelationshipStatus.PENDING)
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connection that = (Connection) o;
        return Objects.equal(connectionId, that.connectionId) &&
                Objects.equal(fromPerson, that.fromPerson) &&
                Objects.equal(toPerson, that.toPerson) &&
                type == that.type &&
                status == that.status &&
                Objects.equal(invitedAt, that.invitedAt) &&
                Objects.equal(acceptedAt, that.acceptedAt) &&
                Objects.equal(rejectedAt, that.rejectedAt) &&
                Objects.equal(archivedAt, that.archivedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(connectionId, fromPerson, toPerson, type, status, invitedAt, acceptedAt, rejectedAt, archivedAt);
    }
}
