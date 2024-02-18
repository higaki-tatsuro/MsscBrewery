package guru.springframework.msscbrewery.web.mappers;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class DateMapper {

    public OffsetDateTime asOffsetDateTime(Timestamp ts){
        if(ts == null){
            return null;
        }

        LocalDateTime ldt = ts.toLocalDateTime();

        return OffsetDateTime.of(ldt.getYear(), ldt.getMonthValue(), ldt.getDayOfMonth(), ldt.getHour(), ldt.getMinute(),
                ldt.getSecond(), ldt.getNano(), ZoneOffset.of("Asia/Tokyo"));
    }

    public Timestamp asTimeStamp(OffsetDateTime offsetDateTime){
        if(offsetDateTime == null){
            return null;
        }

        return Timestamp.valueOf(offsetDateTime.atZoneSameInstant(ZoneOffset.of("Asia/Tokyo")).toLocalDateTime());
    }
}
