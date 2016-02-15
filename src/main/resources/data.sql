-- login password
-- test test
-- user1 user
-- user2 user
INSERT INTO `users` VALUES
  (1, 'test', '$2a$10$4aJTgreEspZNd.e9iAhTbu.WLiOAPjXx0gnduutXLlKOfYf7hlSue', 'ADMIN'),
  (2, 'user1', '$2a$10$8Pjsfxf.qpLok9W2MxeoouZB2hxylo0jhUqO099oDR4NvsvC0GivW', 'USER'),
  (3, 'user2', '$2a$10$8Pjsfxf.qpLok9W2MxeoouZB2hxylo0jhUqO099oDR4NvsvC0GivW', 'USER');

INSERT INTO `deposits` (`id`, `number`, `balance`, `created`, `account_id`) VALUES
  (1, '1111_9090909', 100, {ts '2012-09-22'}, 2),
  (2, '2222_7878787', 500, {ts '2013-11-17'}, 2),
  (3, '1111_6565656', 200, {ts '2014-03-01'}, 3),
  (4, '2222_4343434', 300, {ts '2015-07-06'}, 3);

INSERT INTO `indexes` VALUES
  (1, '1111'),
  (2, '2222');
