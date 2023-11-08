INSERT INTO USERS (ID, DISPLAY_NAME) VALUES ('fd282131-d8aa-4819-b0c8-d9e0bfb1b75c', 'gianniWehner');
INSERT INTO USERS (ID, DISPLAY_NAME) VALUES ('fa1529de-5f20-49a7-ad25-a494008dd322', 'jarenKerluke');
INSERT INTO USERS (ID, DISPLAY_NAME) VALUES ('aa569071-6ade-4ff6-b567-6466fcbae74a', 'marionKertzmann');
INSERT INTO USERS (ID, DISPLAY_NAME) VALUES ('1b140966-5a01-49da-872e-71a769f98941', 'carmeloStark');
INSERT INTO USERS (ID, DISPLAY_NAME) VALUES ('fddcde65-70b2-49f9-8b4d-5126adc345c1', 'brendenVolkman');

INSERT INTO TEAMS (ID, NAME, TEAM_LEAD_ID) VALUES ('7676a4bf-adfe-415c-941b-1739af07039b', 'Ordinary Coral Lynx', 'b12fa35a-9c4c-4bf9-8f32-27cf03a1f190');
INSERT INTO TEAMS (ID, NAME, TEAM_LEAD_ID) VALUES ('5071b4fc-43f2-47a2-8403-e934dc270606', 'Weekly Peach Wildebeest', '7ca5f476-4beb-4aae-9a50-2ac5c78be9e9');
INSERT INTO TEAMS (ID, NAME, TEAM_LEAD_ID) VALUES ('7cf0d32d-036f-40b6-86ea-2473d4ccaecd', 'Surrounding Gold Pheasan', '51d8b058-8dbf-4b83-8a13-4fb0af125e08');
INSERT INTO TEAMS (ID, NAME, TEAM_LEAD_ID) VALUES ('de01d852-c519-4c54-b95a-80c5b6fa0157', 'Feminist Maroon Gorilla', '39a40855-8f8a-4d14-81f9-80d1f76a93cb');
INSERT INTO TEAMS (ID, NAME, TEAM_LEAD_ID) VALUES ('89a50743-f60b-4345-a772-9d3c68021408', 'Resident Scarlet Hare', 'd666d0cd-4a5f-45ca-9f4c-2e390e26d76c');

INSERT INTO USER_ROLES (id, team_id, user_id, role, membership) VALUES (1, '7676a4bf-adfe-415c-941b-1739af07039b', 'fd282131-d8aa-4819-b0c8-d9e0bfb1b75c', 'Developer', 'None');
INSERT INTO USER_ROLES (id, team_id, user_id, role, membership) VALUES (2, '7676a4bf-adfe-415c-941b-1739af07039b', 'fa1529de-5f20-49a7-ad25-a494008dd322', 'Product Owner', 'None');
INSERT INTO USER_ROLES (id, team_id, user_id, role, membership) VALUES (3, '5071b4fc-43f2-47a2-8403-e934dc270606', 'fa1529de-5f20-49a7-ad25-a494008dd322', 'Tester', 'None');
INSERT INTO USER_ROLES (id, team_id, user_id, role, membership) VALUES (4, '7cf0d32d-036f-40b6-86ea-2473d4ccaecd', 'aa569071-6ade-4ff6-b567-6466fcbae74a', 'Developer', 'None');
INSERT INTO USER_ROLES (id, team_id, user_id, role, membership) VALUES (5, 'de01d852-c519-4c54-b95a-80c5b6fa0157', 'fddcde65-70b2-49f9-8b4d-5126adc345c1', 'Developer', 'None');