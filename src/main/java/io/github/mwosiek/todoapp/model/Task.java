    package io.github.mwosiek.todoapp.model;

    import io.github.mwosiek.todoapp.model.event.TaskEvent;

    import javax.persistence.*;
    import javax.validation.constraints.NotBlank;
    import java.time.LocalDateTime;

    @Entity
    @Table(name = "tasks")
    public class Task {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @NotBlank(message = "Tasks description cannot be empty.")
        private String description;
        private boolean done;
        private LocalDateTime deadline;
        @Embedded
        private Audit audit = new Audit();

        @ManyToOne
        @JoinColumn(name = "task_group_id")
        private TaskGroup group;

        Task() {
        }

        public Task(String description, LocalDateTime deadline) {
            this(description, deadline, null);
        }

        public Task(String description, LocalDateTime deadline, TaskGroup group) {
            this.description = description;
            this.deadline = deadline;
            if (group != null) {
                this.group = group;
            }
        }

        public int getId()
        {
            return id;
        }

        void setId(final int id)
        {
            this.id = id;
        }

        public String getDescription()
        {
            return description;
        }

        void setDescription(final String description)
        {
            this.description = description;
        }

        public boolean isDone()
        {
            return done;
        }

        public TaskEvent toggle() {
            this.done = !this.done;
            return TaskEvent.changed(this);
        }

        public LocalDateTime getDeadLine() { return deadline; }


        TaskGroup getGroup() {
            return group;
        }

        void setDeadline(final LocalDateTime deadline) {
            this.deadline = deadline;
        }

        public void updateFrom (final Task source) {
            description = source.description;
            done = source.done;
            deadline = source.deadline;
            group = source.group;
        }

    }


