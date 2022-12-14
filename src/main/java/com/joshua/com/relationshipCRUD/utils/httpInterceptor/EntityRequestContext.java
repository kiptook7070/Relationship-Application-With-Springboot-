package com.joshua.com.relationshipCRUD.utils.httpInterceptor;

public class EntityRequestContext {
    private static ThreadLocal<String> entityId = new InheritableThreadLocal<>();

    public static String getCurrentEntityId() {
        return entityId.get();
    }

    public static void setCurrentEntityId(String tenant) {
        entityId.set(tenant);
    }

    public static void clear() {
        entityId.set(null);
    }
}
