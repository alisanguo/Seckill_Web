DELIMITER $$
  CREATE  PROCEDURE  `seckill`.`executeKill`(in v_scekillId bigint,in v_phone bigint,out result INT )
  BEGIN
    DECLARE update_count INT DEFAULT -3;
    DECLARE insert_count INT DEFAULT 0;
    start  TRANSACTION;
     INSERT IGNORE INTO success_killed(seckill_id,user_phone,status,create_time)
     	VALUES(1001,22222222222,0,NULL);
    SELECT ROW_COUNT() INTO insert_count;
    IF insert_count=0 THEN
      ROLLBACK;
      SET result=3;
    ELSEIF insert_count<0 THEN
      ROLLBACK ;
      SET result=5;
    ELSE
      UPDATE seckill SET number=number-1
        WHERE seckillId=seckillId
        AND beginTime<v_killTime
        AND endtime>v_killTime
        AND number>0;
      SELECT ROW_COUNT() INTO update_count;
      IF update_count=0 THEN
        ROLLBACK;
        SET result=2;
      ELSEIF insert_count<0 THEN
        ROLLBACK ;
        SET result=5;
      ELSE
        COMMIT ;
        SET result=1;
      END IF;
    END IF;
  END;
  $$


DELIMITER ;
