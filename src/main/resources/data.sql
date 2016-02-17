-- login password
-- test test
-- user1 user
-- user2 user
INSERT INTO `users` VALUES
  (1, 'test', '$2a$10$4aJTgreEspZNd.e9iAhTbu.WLiOAPjXx0gnduutXLlKOfYf7hlSue', 'ADMIN'),
  (2, 'user1', '$2a$10$8Pjsfxf.qpLok9W2MxeoouZB2hxylo0jhUqO099oDR4NvsvC0GivW', 'USER'),
  (3, 'user2', '$2a$10$8Pjsfxf.qpLok9W2MxeoouZB2hxylo0jhUqO099oDR4NvsvC0GivW', 'USER');

INSERT INTO `deposits` (`id`, `number`, `balance`, `closed`, `account_id`) VALUES
  (1, '1111_9090909', 100, false, 2),
  (2, '2222_7878787', 500, false, 2),
  (3, '1111_6565656', 200, false, 3),
  (4, '2222_4343434', 300, false, 3);

INSERT INTO `indexes` VALUES
  (1, '1111'),
  (2, '2222');

INSERT INTO `transactions` (`id`, `user`, `amount`, `from_deposit`, `to_user`, `to_deposit`, `created`) VALUES
  (1, 'user1', 15, '2222_7878787', 'user2', '1111_6565656', {ts '2015-01-20'}),
  (2, 'user1', 30, '2222_7878787', 'user2', '2222_4343434', {ts '2016-01-25'});
