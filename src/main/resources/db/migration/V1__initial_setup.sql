CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE organizations (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(255) NOT NULL,
    address TEXT,
    contact_email VARCHAR(255),
    contact_phone VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS instructors (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    birth_date DATE NOT NULL,
    organization_id UUID REFERENCES organizations(id) ON DELETE SET NULL
);

CREATE TABLE events (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    instructor_id UUID REFERENCES instructors(id) ON DELETE CASCADE,
    start_date TIMESTAMP WITH TIME ZONE NOT NULL,
    end_date TIMESTAMP WITH TIME ZONE NOT NULL,
    event_type VARCHAR(100) NOT NULL,
    description TEXT,
    CONSTRAINT chk_dates CHECK (end_date > start_date)
);

INSERT INTO organizations (id, name, address, contact_email, contact_phone) VALUES
    ('f19067d5-62a2-4ad4-98db-0db77a2fdb27', 'MINT Software Systems', '123 Tech Valley, Innovate City', 'info@mintsystems.com', '555-1234-5678');

INSERT INTO instructors (id, first_name, last_name, birth_date, organization_id) VALUES
    ('4eb212f0-8262-4f24-9e8b-6f608c0d4134', 'Lara', 'Croft', '1990-01-01', 'f19067d5-62a2-4ad4-98db-0db77a2fdb27'),
    ('7a5ba2ea-b566-4bbd-b4a1-41c61b398447', 'Ryu', 'Hayabusa', '1991-02-01', 'f19067d5-62a2-4ad4-98db-0db77a2fdb27'),
    ('08301e7d-76dc-4474-b0ab-1e82a399bca4', 'Ezio', 'Auditore', '1992-03-01', 'f19067d5-62a2-4ad4-98db-0db77a2fdb27'),
    ('68e1ecca-ca57-4009-acb0-df51c5e48386', 'Jill', 'Valentine', '1993-04-01', 'f19067d5-62a2-4ad4-98db-0db77a2fdb27'),
    ('60ff3bf9-f3e0-4e22-9c36-36ddbe7f9060', 'Jack', 'Sparrow', '1994-05-01', 'f19067d5-62a2-4ad4-98db-0db77a2fdb27');

INSERT INTO events (instructor_id, start_date, end_date, event_type, description) VALUES
    ('4eb212f0-8262-4f24-9e8b-6f608c0d4134', '2024-09-01T00:00:00Z', '2024-09-07T23:59:59Z', 'OFF', 'Vacation Week'),
    ('4eb212f0-8262-4f24-9e8b-6f608c0d4134', '2024-09-15T00:00:00Z', '2024-09-21T23:59:59Z', 'SEMINAR', 'First Seminar Week'),
    ('4eb212f0-8262-4f24-9e8b-6f608c0d4134', '2024-10-01T00:00:00Z', '2024-10-07T23:59:59Z', 'SEMINAR', 'Second Seminar Week'),
    ('4eb212f0-8262-4f24-9e8b-6f608c0d4134', '2024-10-15T00:00:00Z', '2024-10-21T23:59:59Z', 'PROJECT', 'Project Week'),
    ('7a5ba2ea-b566-4bbd-b4a1-41c61b398447', '2024-09-08T00:00:00Z', '2024-09-14T23:59:59Z', 'OFF', 'Vacation Week'),
    ('7a5ba2ea-b566-4bbd-b4a1-41c61b398447', '2024-09-22T00:00:00Z', '2024-09-28T23:59:59Z', 'SEMINAR', 'First Seminar Week'),
    ('7a5ba2ea-b566-4bbd-b4a1-41c61b398447', '2024-10-08T00:00:00Z', '2024-10-14T23:59:59Z', 'SEMINAR', 'Second Seminar Week'),
    ('7a5ba2ea-b566-4bbd-b4a1-41c61b398447', '2024-10-22T00:00:00Z', '2024-10-28T23:59:59Z', 'PROJECT', 'Project Week'),
    ('08301e7d-76dc-4474-b0ab-1e82a399bca4', '2024-09-09T00:00:00Z', '2024-09-15T23:59:59Z', 'OFF', 'Vacation Week'),
    ('08301e7d-76dc-4474-b0ab-1e82a399bca4', '2024-09-23T00:00:00Z', '2024-09-29T23:59:59Z', 'SEMINAR', 'First Seminar Week'),
    ('08301e7d-76dc-4474-b0ab-1e82a399bca4', '2024-10-09T00:00:00Z', '2024-10-15T23:59:59Z', 'SEMINAR', 'Second Seminar Week'),
    ('08301e7d-76dc-4474-b0ab-1e82a399bca4', '2024-10-23T00:00:00Z', '2024-10-29T23:59:59Z', 'PROJECT', 'Project Week'),
    ('68e1ecca-ca57-4009-acb0-df51c5e48386', '2024-09-02T00:00:00Z', '2024-09-08T23:59:59Z', 'OFF', 'Vacation Week'),
    ('68e1ecca-ca57-4009-acb0-df51c5e48386', '2024-09-16T00:00:00Z', '2024-09-22T23:59:59Z', 'SEMINAR', 'First Seminar Week'),
    ('68e1ecca-ca57-4009-acb0-df51c5e48386', '2024-10-02T00:00:00Z', '2024-10-08T23:59:59Z', 'SEMINAR', 'Second Seminar Week'),
    ('68e1ecca-ca57-4009-acb0-df51c5e48386', '2024-10-16T00:00:00Z', '2024-10-22T23:59:59Z', 'PROJECT', 'Project Week'),
    ('60ff3bf9-f3e0-4e22-9c36-36ddbe7f9060', '2024-09-03T00:00:00Z', '2024-09-09T23:59:59Z', 'OFF', 'Vacation Week'),
    ('60ff3bf9-f3e0-4e22-9c36-36ddbe7f9060', '2024-09-17T00:00:00Z', '2024-09-23T23:59:59Z', 'SEMINAR', 'First Seminar Week'),
    ('60ff3bf9-f3e0-4e22-9c36-36ddbe7f9060', '2024-10-03T00:00:00Z', '2024-10-09T23:59:59Z', 'SEMINAR', 'Second Seminar Week'),
    ('60ff3bf9-f3e0-4e22-9c36-36ddbe7f9060', '2024-10-17T00:00:00Z', '2024-10-23T23:59:59Z', 'PROJECT', 'Project Week');
