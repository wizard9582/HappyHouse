use happyhouse;

#SET GLOBAL TIME_ZONE = 'Asia/Seoul';

DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `board`;

CREATE TABLE user(
 id 						integer NOT NULL AUTO_INCREMENT,
 name						VARCHAR(25)  NOT NULL,
 nick						VARCHAR(25)  NOT NULL,
 pass						VARCHAR(25)  NOT NULL,
 address                    VARCHAR(25),
 phone                 		VARCHAR(25)  NOT NULL,

PRIMARY KEY (id)
);


CREATE TABLE board(
 no 						integer NOT NULL AUTO_INCREMENT,
 apt						VARCHAR(25)  NOT NULL,
 title						VARCHAR(25)  NOT NULL,
 author						VARCHAR(25)  NOT NULL,
 date                    	timestamp,
 content                 	VARCHAR(255),
 
PRIMARY KEY (no)
);

INSERT INTO user VALUES (null, '심재원', 'jwsims',
   '1234', '서울시', '01071067542');
INSERT INTO user VALUES (null, '노진혁', 'no',
   '1234', '부천시', '01000000000');
INSERT INTO user VALUES (null, '노진구', 'NOO',
   '1234', '서울시', '01011111111');

INSERT INTO board VALUES (null, '래미안', '고발합니다','심재원',now(),'살기좋음');
INSERT INTO board VALUES (null, '뤠미안', '더럽게','노진혁',now(),'살기좋음');
INSERT INTO board VALUES (null, '안미안', '별로','노진구',now(),'이사하고싶지않음');
commit;   
select * from user; 
select * from board;  