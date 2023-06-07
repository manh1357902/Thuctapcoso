use bookstore1;
insert into role(code,name) values('ADMIN','ADMIN');
insert into role(code,name) values('USER','USER');

insert into user(username, password, fullname) values ('admin', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 'Nguyễn Công Mạnh');
insert into user(username, password, fullname) values ('manh123', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 'Nguyễn Công Mạnh');
insert into user(username, password, fullname) values ('manh124', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG', 'Nguyễn Công');

insert into user_role(userid,roleid) values (1,1);
insert into user_role(userid,roleid) values (2,2);
insert into user_role(userid,roleid) values (3,2);
-- delete from user_role where roleid = 2; 

insert into category(name) values ('Truyện tranh');
insert into category(name) values ('Văn học');
insert into category(name) values ('Khoa học');
insert into book(title, img, author, price, quantity, description, page, publisher, category_id) 
values ('Chút Sự Thật Của Người Nổi Tiếng (Tập 2)', 'anh1.jpg', 'Dương Thụy', 25000, 10, 'Bạn đang cầm trên tay cuốn sách của Dương Thúy. Dương Thúy không phải là Vệ Tuệ, cũng chả phải Quỳnh Dao. Hai kẻ đó viết văn, còn Dương Thúy viết người. Có thể khẳng định, viết về người rất khó, nhất là lại viết theo mồm người ấy kể. Nhưng nàng (tức Dương Thúy) đã làm được việc này một cách.....', 204, 'NXB Thanh Niên', 1);
insert into book(title, img, author, price, quantity, description, page, publisher, category_id) 
values ('The Knowledge - Khảo Cổ Dễ Sợ', 'the-knowledge-khao-co-de-so_122357_1.jpg', 'Clive Goddard', 39000, 100, 'Cuốn chỉ dẫn lạ đời này là thứ tuyệt vời để đọc nếu bạn mê những di tích khảo cổ xưa và muốn đào bới vào những bí mật kinh dị! Mời bạn theo chân những nhà khảo cổ dưới nước gan dạ chui vào những hang động tử thần, tìm ra bộ mặt thật của chiếc đầu lâu, bật mí những bí mật ghê rợn của xác ướp vùng đầm lầy và những thứ kinh sợ thời tiền sử.',160,'NXB Trẻ',2);
insert into book(title, img, author, price, quantity, description, page, publisher, category_id) 
values ('The Knowledge - Khủng Long Khủng Khỉnh', 'the-knowledge-khung-long-khung-khinh-_122356_1.jpg', 'Martin Oliver', 34500, 10, 'Đầu tiên những con khủng long xuất hiện, tiến hóa và cai trị trái đất này triệu triệu năm…Rồi một sự kiện lạ lùng xảy ra, thế là cả bọn chết hết… Thông tin về các loại khủng long đó cho đến bây giờ vãn chưa ai biết hết được! Cuốn sách chỉ dẫn lợi hại này sẽ cho bạn biết nhiều hơn là những cái xương khảo cổ trụi thùi lụi. Bạn sẽ khám phá vài con trong số bọn thú đáng kinh ngạc từng tồn tại, và đọc vài điều huyền bí mà những cổ sinh vật học tầm thường đang trối chết giải quyết. Bạn sẽ tìm hiểu về bọn khủng - long - gây - họa, khủng - long - ăn - kiêng, và thậm chí cả những di hài thối rữa giống như… phân của chúng! Hãy đem ra một con T-rex, thử tài bạn bè bằng những câu đố về bọn khủng long khủng khỉnh trong sách, xem liệu bạn có thể trở thành thám tử khủng long không nhé!', 132, 'NXB Trẻ', 2);
insert into book(title, img, author, price, quantity, description, page, publisher, category_id) 
values ('Vĩnh Biệt, Cảm Ơn Vì Đã Cho Ăn Cá', 'vinh-biet-cam-on-vi-da-cho-an-ca.jpg', 'DOUGLAS ADAMS', 120000, 30, 'Tám năm lưu lạc trong Vũ Trụ, và đây, Arthur Dent lại được đĩa bay thả xuống một hành tinh nhỏ sau một chuyến quá giang dài dằng dặc băng qua dải Ngân Hà. Giữa đêm đen mịt mùng. Trong dông tố bão bùng. Anh đứng chờ.\nMột chiếc ô tô lướt qua.\nTRÁI ĐẤT! Quê nhà đây ư? Chẳng phải hành tinh xanh lơ xanh lá này đã bị san phẳng để xây đường cao tốc liên không gian rồi sao? Có lẽ nào bao nhiêu năm tháng bị quăng quật nhừ tử trong Ngân Hà vừa qua chỉ là một “ảo giác”?\nDẫu những màn trào phúng đặc sệt Anh vẫn là không khí bao trùm series Bí kíp quá giang vào Ngân Hà, cuốn thứ tư của bộ truyện dễ dàng đứng tách biệt và nổi bật. Chính ở đây, độc giả yêu thích những câu chuyện có hậu sẽ tìm được cho mình một cái kết thỏa mãn cho một cuộc phiêu lưu kỳ thú nho nhỏ và một mối tình bay bổng lãng mạn.', 204, 'NXB Thanh Niên', 3);
insert into book(title, img, author, price, quantity, description, page, publisher, category_id) 
values ('Cơn Cuồng Si', 'con-cuong-si.jpg', 'Annie Ernaux', 68000, 1, 'Xuất bản tại Pháp năm 1991, Cơn Cuồng Si đánh dấu sự đoạn tuyệt của tác giả so với năm tác phẩm trước đó bằng việc khai thác chủ đề đam mê tình dục, chủ đề mà bà chỉ có thể đề cập trực tiếp sau khi mẹ mình đã qua đời. Trong cuốn sách rất mỏng và khó xếp loại này, bà kể lại cuộc phiêu lưu tình ái ngắn ngủi của mình với một nhà ngoại giao nước ngoài đã có vợ, một cuộc tình vụng trộm, thoáng qua nhưng mãnh liệt, đầy đam mê và đã để lại cho bà nhiều khổ đau, nhung nhớ.', 80, 'NXB Hội Nhà Văn', 3);
insert into book(title, img, author, price, quantity, description, page, publisher, category_id) 
values ('Dế Mèn Phiêu Lưu Ký ', 'demenphieuluukycndYJTdFww.jpg', 'Tô Hoài', 149950, 10, 'Dế mèn phiêu lưu ký là truyện dài của nhà văn Tô Hoài kể về cuộc phiêu lưu của chú Dế Mèn cùng các bạn bè.
Trên đường đi, họ đã gặp phải nhiều khó khăn nguy hiểm, nhưng những gian nan đã cho họ nhiều bài học quý giá, và thắt chặt tình bạn của họ. 
Ngoài việc khuyến khích những người trẻ tuổi dám mơ ước, dám hành động, truyện còn là khát vọng hoà bình giữa các loài, là mong ước anh em bốn bể có thể cùng chung sống hoà thuận, để thế giới không còn cảnh xung đột, thù ghét.', 140, 'NXB Kim Đồng', 3);
insert into book(title, img, author, price, quantity, description, page, publisher, category_id) 
values ('Lược Sử Thời Gian', 'luoc-su-thoi-gian.png', 'Stephen Hawking', 73950, 10, 'Cùng với Vũ trụ trong vỏ hạt dẻ, Lược sử thời gian được xem là cuốn sách nổi tiếng và phổ biến nhất về vũ trụ học của Stephen Hawking, liên tục được nằm trong danh mục sách bán chạy nhất của các tạp chí nổi tiếng thế giới. Lược sử thời gian là cuốn sử thi về sự ra đời, sự hình thành và phát triển của vũ trụ. Tác giả đưa vào tác phẩm của mình toàn bộ tiến bộ tiến trình khám phá của trí tuệ loài người trên nhiều lĩnh vực: Triết học, Vật lý, Thiên văn học… Nhân dịp kỷ niệm lần in thứ 10 xin trân trọng giới thiệu cùng bạn đọc.', 286, 'NXB Trẻ', 4);
