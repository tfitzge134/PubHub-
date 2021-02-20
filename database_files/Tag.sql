--Select * from books; to check data to get the isbn_number
drop table if exists book_tags;

create table book_tags (
  isbn_13 varchar (13) references books(isbn_13),
  tags_name varchar (100),
  primary key (isbn_13, tags_name)
);
insert into book_tags (isbn_13, tags_name) values (
  '1111111111111',          	-- id
  'Adventures'    -- booktag
);
--checking insertion in table
select * from book_tags
--check data
--  select * from book_tags



						
-- 					   )
				
				
				
					   
-- -- 					   Afterwards, insert one row of dummy data that adds
-- -- 					   a tag to the sample book in the BOOKS table.

-- create table books (
--   isbn_13 varchar (13) primary key,
--   title varchar (100),
--   author varchar (80),
--   publish_date date,
--   price decimal (6,2),
--   content bytea
-- );

-- insert into books values (
--   '1111111111111',          	-- id
--   'The Adventures of Steve',    -- title
--   'Russell Barron', 			-- author
--   current_date,    				-- publishDate
--   123.50,   					-- price
--   null							-- blob
-- );