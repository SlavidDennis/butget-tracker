ALTER TABLE vendor_group ADD COLUMN user_profile_uuid VARCHAR(200);
ALTER TABLE vendor_group ADD CONSTRAINT vendor_group_user_profile_fk FOREIGN KEY (user_profile_uuid) REFERENCES user_profile (uuid);