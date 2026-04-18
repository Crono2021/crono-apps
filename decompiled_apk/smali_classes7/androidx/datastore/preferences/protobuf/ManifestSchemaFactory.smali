.class final Landroidx/datastore/preferences/protobuf/ManifestSchemaFactory;
.super Ljava/lang/Object;
.source "ManifestSchemaFactory.java"

# interfaces
.implements Landroidx/datastore/preferences/protobuf/SchemaFactory;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/datastore/preferences/protobuf/ManifestSchemaFactory$CompositeMessageInfoFactory;
    }
.end annotation


# static fields
.field private static final EMPTY_FACTORY:Landroidx/datastore/preferences/protobuf/MessageInfoFactory;


# instance fields
.field private final messageInfoFactory:Landroidx/datastore/preferences/protobuf/MessageInfoFactory;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 151
    new-instance v0, Landroidx/datastore/preferences/protobuf/ManifestSchemaFactory$1;

    invoke-direct {v0}, Landroidx/datastore/preferences/protobuf/ManifestSchemaFactory$1;-><init>()V

    sput-object v0, Landroidx/datastore/preferences/protobuf/ManifestSchemaFactory;->EMPTY_FACTORY:Landroidx/datastore/preferences/protobuf/MessageInfoFactory;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .line 44
    invoke-static {}, Landroidx/datastore/preferences/protobuf/ManifestSchemaFactory;->getDefaultMessageInfoFactory()Landroidx/datastore/preferences/protobuf/MessageInfoFactory;

    move-result-object v0

    invoke-direct {p0, v0}, Landroidx/datastore/preferences/protobuf/ManifestSchemaFactory;-><init>(Landroidx/datastore/preferences/protobuf/MessageInfoFactory;)V

    .line 45
    return-void
.end method

.method private constructor <init>(Landroidx/datastore/preferences/protobuf/MessageInfoFactory;)V
    .locals 1
    .param p1, "messageInfoFactory"    # Landroidx/datastore/preferences/protobuf/MessageInfoFactory;

    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    const-string/jumbo v0, "messageInfoFactory"

    invoke-static {p1, v0}, Landroidx/datastore/preferences/protobuf/Internal;->checkNotNull(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/MessageInfoFactory;

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/ManifestSchemaFactory;->messageInfoFactory:Landroidx/datastore/preferences/protobuf/MessageInfoFactory;

    .line 49
    return-void
.end method

.method private static getDefaultMessageInfoFactory()Landroidx/datastore/preferences/protobuf/MessageInfoFactory;
    .locals 4

    .line 118
    new-instance v0, Landroidx/datastore/preferences/protobuf/ManifestSchemaFactory$CompositeMessageInfoFactory;

    const/4 v1, 0x2

    new-array v1, v1, [Landroidx/datastore/preferences/protobuf/MessageInfoFactory;

    .line 119
    invoke-static {}, Landroidx/datastore/preferences/protobuf/GeneratedMessageInfoFactory;->getInstance()Landroidx/datastore/preferences/protobuf/GeneratedMessageInfoFactory;

    move-result-object v2

    const/4 v3, 0x0

    aput-object v2, v1, v3

    const/4 v2, 0x1

    invoke-static {}, Landroidx/datastore/preferences/protobuf/ManifestSchemaFactory;->getDescriptorMessageInfoFactory()Landroidx/datastore/preferences/protobuf/MessageInfoFactory;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-direct {v0, v1}, Landroidx/datastore/preferences/protobuf/ManifestSchemaFactory$CompositeMessageInfoFactory;-><init>([Landroidx/datastore/preferences/protobuf/MessageInfoFactory;)V

    .line 118
    return-object v0
.end method

.method private static getDescriptorMessageInfoFactory()Landroidx/datastore/preferences/protobuf/MessageInfoFactory;
    .locals 4

    .line 166
    :try_start_0
    const-string v0, "androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 167
    .local v0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-string v1, "getInstance"

    const/4 v2, 0x0

    new-array v3, v2, [Ljava/lang/Class;

    invoke-virtual {v0, v1, v3}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {v1, v3, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/datastore/preferences/protobuf/MessageInfoFactory;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object v1

    .line 168
    .end local v0    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :catch_0
    move-exception v0

    .line 169
    .local v0, "e":Ljava/lang/Exception;
    sget-object v1, Landroidx/datastore/preferences/protobuf/ManifestSchemaFactory;->EMPTY_FACTORY:Landroidx/datastore/preferences/protobuf/MessageInfoFactory;

    return-object v1
.end method

.method private static isProto2(Landroidx/datastore/preferences/protobuf/MessageInfo;)Z
    .locals 2
    .param p0, "messageInfo"    # Landroidx/datastore/preferences/protobuf/MessageInfo;

    .line 114
    invoke-interface {p0}, Landroidx/datastore/preferences/protobuf/MessageInfo;->getSyntax()Landroidx/datastore/preferences/protobuf/ProtoSyntax;

    move-result-object v0

    sget-object v1, Landroidx/datastore/preferences/protobuf/ProtoSyntax;->PROTO2:Landroidx/datastore/preferences/protobuf/ProtoSyntax;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method private static newSchema(Ljava/lang/Class;Landroidx/datastore/preferences/protobuf/MessageInfo;)Landroidx/datastore/preferences/protobuf/Schema;
    .locals 8
    .param p1, "messageInfo"    # Landroidx/datastore/preferences/protobuf/MessageInfo;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;",
            "Landroidx/datastore/preferences/protobuf/MessageInfo;",
            ")",
            "Landroidx/datastore/preferences/protobuf/Schema<",
            "TT;>;"
        }
    .end annotation

    .line 75
    .local p0, "messageType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    const-class v0, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    invoke-virtual {v0, p0}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 76
    invoke-static {p1}, Landroidx/datastore/preferences/protobuf/ManifestSchemaFactory;->isProto2(Landroidx/datastore/preferences/protobuf/MessageInfo;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 80
    invoke-static {}, Landroidx/datastore/preferences/protobuf/NewInstanceSchemas;->lite()Landroidx/datastore/preferences/protobuf/NewInstanceSchema;

    move-result-object v3

    .line 81
    invoke-static {}, Landroidx/datastore/preferences/protobuf/ListFieldSchema;->lite()Landroidx/datastore/preferences/protobuf/ListFieldSchema;

    move-result-object v4

    .line 82
    invoke-static {}, Landroidx/datastore/preferences/protobuf/SchemaUtil;->unknownFieldSetLiteSchema()Landroidx/datastore/preferences/protobuf/UnknownFieldSchema;

    move-result-object v5

    .line 83
    invoke-static {}, Landroidx/datastore/preferences/protobuf/ExtensionSchemas;->lite()Landroidx/datastore/preferences/protobuf/ExtensionSchema;

    move-result-object v6

    .line 84
    invoke-static {}, Landroidx/datastore/preferences/protobuf/MapFieldSchemas;->lite()Landroidx/datastore/preferences/protobuf/MapFieldSchema;

    move-result-object v7

    .line 77
    move-object v1, p0

    move-object v2, p1

    invoke-static/range {v1 .. v7}, Landroidx/datastore/preferences/protobuf/MessageSchema;->newSchema(Ljava/lang/Class;Landroidx/datastore/preferences/protobuf/MessageInfo;Landroidx/datastore/preferences/protobuf/NewInstanceSchema;Landroidx/datastore/preferences/protobuf/ListFieldSchema;Landroidx/datastore/preferences/protobuf/UnknownFieldSchema;Landroidx/datastore/preferences/protobuf/ExtensionSchema;Landroidx/datastore/preferences/protobuf/MapFieldSchema;)Landroidx/datastore/preferences/protobuf/MessageSchema;

    move-result-object v0

    goto :goto_0

    .line 88
    :cond_0
    invoke-static {}, Landroidx/datastore/preferences/protobuf/NewInstanceSchemas;->lite()Landroidx/datastore/preferences/protobuf/NewInstanceSchema;

    move-result-object v3

    .line 89
    invoke-static {}, Landroidx/datastore/preferences/protobuf/ListFieldSchema;->lite()Landroidx/datastore/preferences/protobuf/ListFieldSchema;

    move-result-object v4

    .line 90
    invoke-static {}, Landroidx/datastore/preferences/protobuf/SchemaUtil;->unknownFieldSetLiteSchema()Landroidx/datastore/preferences/protobuf/UnknownFieldSchema;

    move-result-object v5

    const/4 v6, 0x0

    .line 92
    invoke-static {}, Landroidx/datastore/preferences/protobuf/MapFieldSchemas;->lite()Landroidx/datastore/preferences/protobuf/MapFieldSchema;

    move-result-object v7

    .line 85
    move-object v1, p0

    move-object v2, p1

    invoke-static/range {v1 .. v7}, Landroidx/datastore/preferences/protobuf/MessageSchema;->newSchema(Ljava/lang/Class;Landroidx/datastore/preferences/protobuf/MessageInfo;Landroidx/datastore/preferences/protobuf/NewInstanceSchema;Landroidx/datastore/preferences/protobuf/ListFieldSchema;Landroidx/datastore/preferences/protobuf/UnknownFieldSchema;Landroidx/datastore/preferences/protobuf/ExtensionSchema;Landroidx/datastore/preferences/protobuf/MapFieldSchema;)Landroidx/datastore/preferences/protobuf/MessageSchema;

    move-result-object v0

    .line 76
    :goto_0
    return-object v0

    .line 94
    :cond_1
    invoke-static {p1}, Landroidx/datastore/preferences/protobuf/ManifestSchemaFactory;->isProto2(Landroidx/datastore/preferences/protobuf/MessageInfo;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 98
    invoke-static {}, Landroidx/datastore/preferences/protobuf/NewInstanceSchemas;->full()Landroidx/datastore/preferences/protobuf/NewInstanceSchema;

    move-result-object v3

    .line 99
    invoke-static {}, Landroidx/datastore/preferences/protobuf/ListFieldSchema;->full()Landroidx/datastore/preferences/protobuf/ListFieldSchema;

    move-result-object v4

    .line 100
    invoke-static {}, Landroidx/datastore/preferences/protobuf/SchemaUtil;->proto2UnknownFieldSetSchema()Landroidx/datastore/preferences/protobuf/UnknownFieldSchema;

    move-result-object v5

    .line 101
    invoke-static {}, Landroidx/datastore/preferences/protobuf/ExtensionSchemas;->full()Landroidx/datastore/preferences/protobuf/ExtensionSchema;

    move-result-object v6

    .line 102
    invoke-static {}, Landroidx/datastore/preferences/protobuf/MapFieldSchemas;->full()Landroidx/datastore/preferences/protobuf/MapFieldSchema;

    move-result-object v7

    .line 95
    move-object v1, p0

    move-object v2, p1

    invoke-static/range {v1 .. v7}, Landroidx/datastore/preferences/protobuf/MessageSchema;->newSchema(Ljava/lang/Class;Landroidx/datastore/preferences/protobuf/MessageInfo;Landroidx/datastore/preferences/protobuf/NewInstanceSchema;Landroidx/datastore/preferences/protobuf/ListFieldSchema;Landroidx/datastore/preferences/protobuf/UnknownFieldSchema;Landroidx/datastore/preferences/protobuf/ExtensionSchema;Landroidx/datastore/preferences/protobuf/MapFieldSchema;)Landroidx/datastore/preferences/protobuf/MessageSchema;

    move-result-object v0

    goto :goto_1

    .line 106
    :cond_2
    invoke-static {}, Landroidx/datastore/preferences/protobuf/NewInstanceSchemas;->full()Landroidx/datastore/preferences/protobuf/NewInstanceSchema;

    move-result-object v3

    .line 107
    invoke-static {}, Landroidx/datastore/preferences/protobuf/ListFieldSchema;->full()Landroidx/datastore/preferences/protobuf/ListFieldSchema;

    move-result-object v4

    .line 108
    invoke-static {}, Landroidx/datastore/preferences/protobuf/SchemaUtil;->proto3UnknownFieldSetSchema()Landroidx/datastore/preferences/protobuf/UnknownFieldSchema;

    move-result-object v5

    const/4 v6, 0x0

    .line 110
    invoke-static {}, Landroidx/datastore/preferences/protobuf/MapFieldSchemas;->full()Landroidx/datastore/preferences/protobuf/MapFieldSchema;

    move-result-object v7

    .line 103
    move-object v1, p0

    move-object v2, p1

    invoke-static/range {v1 .. v7}, Landroidx/datastore/preferences/protobuf/MessageSchema;->newSchema(Ljava/lang/Class;Landroidx/datastore/preferences/protobuf/MessageInfo;Landroidx/datastore/preferences/protobuf/NewInstanceSchema;Landroidx/datastore/preferences/protobuf/ListFieldSchema;Landroidx/datastore/preferences/protobuf/UnknownFieldSchema;Landroidx/datastore/preferences/protobuf/ExtensionSchema;Landroidx/datastore/preferences/protobuf/MapFieldSchema;)Landroidx/datastore/preferences/protobuf/MessageSchema;

    move-result-object v0

    .line 94
    :goto_1
    return-object v0
.end method


# virtual methods
.method public createSchema(Ljava/lang/Class;)Landroidx/datastore/preferences/protobuf/Schema;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class<",
            "TT;>;)",
            "Landroidx/datastore/preferences/protobuf/Schema<",
            "TT;>;"
        }
    .end annotation

    .line 53
    .local p1, "messageType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    invoke-static {p1}, Landroidx/datastore/preferences/protobuf/SchemaUtil;->requireGeneratedMessage(Ljava/lang/Class;)V

    .line 55
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/ManifestSchemaFactory;->messageInfoFactory:Landroidx/datastore/preferences/protobuf/MessageInfoFactory;

    invoke-interface {v0, p1}, Landroidx/datastore/preferences/protobuf/MessageInfoFactory;->messageInfoFor(Ljava/lang/Class;)Landroidx/datastore/preferences/protobuf/MessageInfo;

    move-result-object v0

    .line 58
    .local v0, "messageInfo":Landroidx/datastore/preferences/protobuf/MessageInfo;
    invoke-interface {v0}, Landroidx/datastore/preferences/protobuf/MessageInfo;->isMessageSetWireFormat()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 59
    const-class v1, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    invoke-virtual {v1, p1}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 61
    invoke-static {}, Landroidx/datastore/preferences/protobuf/SchemaUtil;->unknownFieldSetLiteSchema()Landroidx/datastore/preferences/protobuf/UnknownFieldSchema;

    move-result-object v1

    .line 62
    invoke-static {}, Landroidx/datastore/preferences/protobuf/ExtensionSchemas;->lite()Landroidx/datastore/preferences/protobuf/ExtensionSchema;

    move-result-object v2

    .line 63
    invoke-interface {v0}, Landroidx/datastore/preferences/protobuf/MessageInfo;->getDefaultInstance()Landroidx/datastore/preferences/protobuf/MessageLite;

    move-result-object v3

    .line 60
    invoke-static {v1, v2, v3}, Landroidx/datastore/preferences/protobuf/MessageSetSchema;->newSchema(Landroidx/datastore/preferences/protobuf/UnknownFieldSchema;Landroidx/datastore/preferences/protobuf/ExtensionSchema;Landroidx/datastore/preferences/protobuf/MessageLite;)Landroidx/datastore/preferences/protobuf/MessageSetSchema;

    move-result-object v1

    return-object v1

    .line 66
    :cond_0
    invoke-static {}, Landroidx/datastore/preferences/protobuf/SchemaUtil;->proto2UnknownFieldSetSchema()Landroidx/datastore/preferences/protobuf/UnknownFieldSchema;

    move-result-object v1

    .line 67
    invoke-static {}, Landroidx/datastore/preferences/protobuf/ExtensionSchemas;->full()Landroidx/datastore/preferences/protobuf/ExtensionSchema;

    move-result-object v2

    .line 68
    invoke-interface {v0}, Landroidx/datastore/preferences/protobuf/MessageInfo;->getDefaultInstance()Landroidx/datastore/preferences/protobuf/MessageLite;

    move-result-object v3

    .line 65
    invoke-static {v1, v2, v3}, Landroidx/datastore/preferences/protobuf/MessageSetSchema;->newSchema(Landroidx/datastore/preferences/protobuf/UnknownFieldSchema;Landroidx/datastore/preferences/protobuf/ExtensionSchema;Landroidx/datastore/preferences/protobuf/MessageLite;)Landroidx/datastore/preferences/protobuf/MessageSetSchema;

    move-result-object v1

    return-object v1

    .line 71
    :cond_1
    invoke-static {p1, v0}, Landroidx/datastore/preferences/protobuf/ManifestSchemaFactory;->newSchema(Ljava/lang/Class;Landroidx/datastore/preferences/protobuf/MessageInfo;)Landroidx/datastore/preferences/protobuf/Schema;

    move-result-object v1

    return-object v1
.end method
