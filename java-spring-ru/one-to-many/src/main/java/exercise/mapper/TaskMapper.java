package exercise.mapper;

import exercise.dto.TaskCreateDTO;
import exercise.dto.TaskDTO;
import exercise.dto.TaskUpdateDTO;
import exercise.model.Task;
import org.mapstruct.*;

@Mapper(uses = {ReferenceMapper.class },
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class TaskMapper {

    // BEGIN
    @Mapping(source = "assigneeId", target = "assignee")
    public abstract Task map(TaskCreateDTO dto);

    @InheritConfiguration
    public abstract void update(TaskUpdateDTO dto, @MappingTarget Task model);

    @Mapping(source = "assignee.id", target = "assigneeId")
    public abstract TaskDTO map(Task model);
    // END

}
