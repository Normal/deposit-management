INSERT INTO `users` VALUES
  (1, 'test', '$2a$10$4aJTgreEspZNd.e9iAhTbu.WLiOAPjXx0gnduutXLlKOfYf7hlSue', 'ADMIN'),
  (2, 'user1', '$2a$10$8Pjsfxf.qpLok9W2MxeoouZB2hxylo0jhUqO099oDR4NvsvC0GivW', 'USER'),
  (3, 'user2', '$2a$10$8Pjsfxf.qpLok9W2MxeoouZB2hxylo0jhUqO099oDR4NvsvC0GivW', 'USER');

INSERT INTO `deposits` (`id`, `number`, `balance`, `created`, `account_id`) VALUES
  (1, '44441', 100, {ts '2012-09-22'}, 2),
  (2, '44442', 500, {ts '2013-11-17'}, 2),
  (3, '44443', 200, {ts '2014-03-01'}, 3),
  (4, '44444', 300, {ts '2015-07-06'}, 3);
