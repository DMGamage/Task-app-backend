package com.example.taskappbackend.util;

import javax.validation.groups.Default;

public interface ValidationGroups {
    interface Create extends Default {
    }

    interface Update extends Default{
    }

    interface Delete extends Default{
    }
}
