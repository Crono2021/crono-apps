.class public final Landroidx/datastore/preferences/protobuf/UInt32Value;
.super Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;
.source "UInt32Value.java"

# interfaces
.implements Landroidx/datastore/preferences/protobuf/UInt32ValueOrBuilder;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/datastore/preferences/protobuf/UInt32Value$Builder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroidx/datastore/preferences/protobuf/GeneratedMessageLite<",
        "Landroidx/datastore/preferences/protobuf/UInt32Value;",
        "Landroidx/datastore/preferences/protobuf/UInt32Value$Builder;",
        ">;",
        "Landroidx/datastore/preferences/protobuf/UInt32ValueOrBuilder;"
    }
.end annotation


# static fields
.field private static final DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/UInt32Value;

.field private static volatile PARSER:Landroidx/datastore/preferences/protobuf/Parser; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/datastore/preferences/protobuf/Parser<",
            "Landroidx/datastore/preferences/protobuf/UInt32Value;",
            ">;"
        }
    .end annotation
.end field

.field public static final VALUE_FIELD_NUMBER:I = 0x1


# instance fields
.field private value_:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 254
    new-instance v0, Landroidx/datastore/preferences/protobuf/UInt32Value;

    invoke-direct {v0}, Landroidx/datastore/preferences/protobuf/UInt32Value;-><init>()V

    .line 257
    .local v0, "defaultInstance":Landroidx/datastore/preferences/protobuf/UInt32Value;
    sput-object v0, Landroidx/datastore/preferences/protobuf/UInt32Value;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/UInt32Value;

    .line 258
    const-class v1, Landroidx/datastore/preferences/protobuf/UInt32Value;

    invoke-static {v1, v0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->registerDefaultInstance(Ljava/lang/Class;Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;)V

    .line 260
    .end local v0    # "defaultInstance":Landroidx/datastore/preferences/protobuf/UInt32Value;
    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 19
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;-><init>()V

    .line 20
    return-void
.end method

.method static synthetic access$000()Landroidx/datastore/preferences/protobuf/UInt32Value;
    .locals 1

    .line 14
    sget-object v0, Landroidx/datastore/preferences/protobuf/UInt32Value;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/UInt32Value;

    return-object v0
.end method

.method static synthetic access$100(Landroidx/datastore/preferences/protobuf/UInt32Value;I)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/UInt32Value;
    .param p1, "x1"    # I

    .line 14
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/UInt32Value;->setValue(I)V

    return-void
.end method

.method static synthetic access$200(Landroidx/datastore/preferences/protobuf/UInt32Value;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/UInt32Value;

    .line 14
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/UInt32Value;->clearValue()V

    return-void
.end method

.method private clearValue()V
    .locals 1

    .line 56
    const/4 v0, 0x0

    iput v0, p0, Landroidx/datastore/preferences/protobuf/UInt32Value;->value_:I

    .line 57
    return-void
.end method

.method public static getDefaultInstance()Landroidx/datastore/preferences/protobuf/UInt32Value;
    .locals 1

    .line 263
    sget-object v0, Landroidx/datastore/preferences/protobuf/UInt32Value;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/UInt32Value;

    return-object v0
.end method

.method public static newBuilder()Landroidx/datastore/preferences/protobuf/UInt32Value$Builder;
    .locals 1

    .line 134
    sget-object v0, Landroidx/datastore/preferences/protobuf/UInt32Value;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/UInt32Value;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/UInt32Value;->createBuilder()Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/UInt32Value$Builder;

    return-object v0
.end method

.method public static newBuilder(Landroidx/datastore/preferences/protobuf/UInt32Value;)Landroidx/datastore/preferences/protobuf/UInt32Value$Builder;
    .locals 1
    .param p0, "prototype"    # Landroidx/datastore/preferences/protobuf/UInt32Value;

    .line 137
    sget-object v0, Landroidx/datastore/preferences/protobuf/UInt32Value;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/UInt32Value;

    invoke-virtual {v0, p0}, Landroidx/datastore/preferences/protobuf/UInt32Value;->createBuilder(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/UInt32Value$Builder;

    return-object v0
.end method

.method public static of(I)Landroidx/datastore/preferences/protobuf/UInt32Value;
    .locals 1
    .param p0, "value"    # I

    .line 267
    invoke-static {}, Landroidx/datastore/preferences/protobuf/UInt32Value;->newBuilder()Landroidx/datastore/preferences/protobuf/UInt32Value$Builder;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroidx/datastore/preferences/protobuf/UInt32Value$Builder;->setValue(I)Landroidx/datastore/preferences/protobuf/UInt32Value$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/UInt32Value$Builder;->build()Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/UInt32Value;

    return-object v0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;)Landroidx/datastore/preferences/protobuf/UInt32Value;
    .locals 1
    .param p0, "input"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 111
    sget-object v0, Landroidx/datastore/preferences/protobuf/UInt32Value;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/UInt32Value;

    invoke-static {v0, p0}, Landroidx/datastore/preferences/protobuf/UInt32Value;->parseDelimitedFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Ljava/io/InputStream;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/UInt32Value;

    return-object v0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/UInt32Value;
    .locals 1
    .param p0, "input"    # Ljava/io/InputStream;
    .param p1, "extensionRegistry"    # Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 117
    sget-object v0, Landroidx/datastore/preferences/protobuf/UInt32Value;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/UInt32Value;

    invoke-static {v0, p0, p1}, Landroidx/datastore/preferences/protobuf/UInt32Value;->parseDelimitedFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Ljava/io/InputStream;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/UInt32Value;

    return-object v0
.end method

.method public static parseFrom(Landroidx/datastore/preferences/protobuf/ByteString;)Landroidx/datastore/preferences/protobuf/UInt32Value;
    .locals 1
    .param p0, "data"    # Landroidx/datastore/preferences/protobuf/ByteString;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/datastore/preferences/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 75
    sget-object v0, Landroidx/datastore/preferences/protobuf/UInt32Value;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/UInt32Value;

    invoke-static {v0, p0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Landroidx/datastore/preferences/protobuf/ByteString;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/UInt32Value;

    return-object v0
.end method

.method public static parseFrom(Landroidx/datastore/preferences/protobuf/ByteString;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/UInt32Value;
    .locals 1
    .param p0, "data"    # Landroidx/datastore/preferences/protobuf/ByteString;
    .param p1, "extensionRegistry"    # Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/datastore/preferences/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 82
    sget-object v0, Landroidx/datastore/preferences/protobuf/UInt32Value;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/UInt32Value;

    invoke-static {v0, p0, p1}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Landroidx/datastore/preferences/protobuf/ByteString;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/UInt32Value;

    return-object v0
.end method

.method public static parseFrom(Landroidx/datastore/preferences/protobuf/CodedInputStream;)Landroidx/datastore/preferences/protobuf/UInt32Value;
    .locals 1
    .param p0, "input"    # Landroidx/datastore/preferences/protobuf/CodedInputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 122
    sget-object v0, Landroidx/datastore/preferences/protobuf/UInt32Value;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/UInt32Value;

    invoke-static {v0, p0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Landroidx/datastore/preferences/protobuf/CodedInputStream;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/UInt32Value;

    return-object v0
.end method

.method public static parseFrom(Landroidx/datastore/preferences/protobuf/CodedInputStream;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/UInt32Value;
    .locals 1
    .param p0, "input"    # Landroidx/datastore/preferences/protobuf/CodedInputStream;
    .param p1, "extensionRegistry"    # Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 129
    sget-object v0, Landroidx/datastore/preferences/protobuf/UInt32Value;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/UInt32Value;

    invoke-static {v0, p0, p1}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Landroidx/datastore/preferences/protobuf/CodedInputStream;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/UInt32Value;

    return-object v0
.end method

.method public static parseFrom(Ljava/io/InputStream;)Landroidx/datastore/preferences/protobuf/UInt32Value;
    .locals 1
    .param p0, "input"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 99
    sget-object v0, Landroidx/datastore/preferences/protobuf/UInt32Value;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/UInt32Value;

    invoke-static {v0, p0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Ljava/io/InputStream;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/UInt32Value;

    return-object v0
.end method

.method public static parseFrom(Ljava/io/InputStream;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/UInt32Value;
    .locals 1
    .param p0, "input"    # Ljava/io/InputStream;
    .param p1, "extensionRegistry"    # Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 106
    sget-object v0, Landroidx/datastore/preferences/protobuf/UInt32Value;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/UInt32Value;

    invoke-static {v0, p0, p1}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Ljava/io/InputStream;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/UInt32Value;

    return-object v0
.end method

.method public static parseFrom(Ljava/nio/ByteBuffer;)Landroidx/datastore/preferences/protobuf/UInt32Value;
    .locals 1
    .param p0, "data"    # Ljava/nio/ByteBuffer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/datastore/preferences/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 62
    sget-object v0, Landroidx/datastore/preferences/protobuf/UInt32Value;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/UInt32Value;

    invoke-static {v0, p0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Ljava/nio/ByteBuffer;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/UInt32Value;

    return-object v0
.end method

.method public static parseFrom(Ljava/nio/ByteBuffer;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/UInt32Value;
    .locals 1
    .param p0, "data"    # Ljava/nio/ByteBuffer;
    .param p1, "extensionRegistry"    # Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/datastore/preferences/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 69
    sget-object v0, Landroidx/datastore/preferences/protobuf/UInt32Value;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/UInt32Value;

    invoke-static {v0, p0, p1}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Ljava/nio/ByteBuffer;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/UInt32Value;

    return-object v0
.end method

.method public static parseFrom([B)Landroidx/datastore/preferences/protobuf/UInt32Value;
    .locals 1
    .param p0, "data"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/datastore/preferences/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 87
    sget-object v0, Landroidx/datastore/preferences/protobuf/UInt32Value;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/UInt32Value;

    invoke-static {v0, p0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;[B)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/UInt32Value;

    return-object v0
.end method

.method public static parseFrom([BLandroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/UInt32Value;
    .locals 1
    .param p0, "data"    # [B
    .param p1, "extensionRegistry"    # Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/datastore/preferences/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 94
    sget-object v0, Landroidx/datastore/preferences/protobuf/UInt32Value;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/UInt32Value;

    invoke-static {v0, p0, p1}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;[BLandroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/UInt32Value;

    return-object v0
.end method

.method public static parser()Landroidx/datastore/preferences/protobuf/Parser;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroidx/datastore/preferences/protobuf/Parser<",
            "Landroidx/datastore/preferences/protobuf/UInt32Value;",
            ">;"
        }
    .end annotation

    .line 273
    sget-object v0, Landroidx/datastore/preferences/protobuf/UInt32Value;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/UInt32Value;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/UInt32Value;->getParserForType()Landroidx/datastore/preferences/protobuf/Parser;

    move-result-object v0

    return-object v0
.end method

.method private setValue(I)V
    .locals 0
    .param p1, "value"    # I

    .line 45
    iput p1, p0, Landroidx/datastore/preferences/protobuf/UInt32Value;->value_:I

    .line 46
    return-void
.end method


# virtual methods
.method protected final dynamicMethod(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$MethodToInvoke;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 4
    .param p1, "method"    # Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$MethodToInvoke;
    .param p2, "arg0"    # Ljava/lang/Object;
    .param p3, "arg1"    # Ljava/lang/Object;

    .line 206
    sget-object v0, Landroidx/datastore/preferences/protobuf/UInt32Value$1;->$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke:[I

    invoke-virtual {p1}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$MethodToInvoke;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x0

    packed-switch v0, :pswitch_data_0

    .line 247
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0

    .line 244
    :pswitch_0
    return-object v1

    .line 241
    :pswitch_1
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v0

    return-object v0

    .line 226
    :pswitch_2
    sget-object v0, Landroidx/datastore/preferences/protobuf/UInt32Value;->PARSER:Landroidx/datastore/preferences/protobuf/Parser;

    .line 227
    .local v0, "parser":Landroidx/datastore/preferences/protobuf/Parser;, "Landroidx/datastore/preferences/protobuf/Parser<Landroidx/datastore/preferences/protobuf/UInt32Value;>;"
    if-nez v0, :cond_1

    .line 228
    const-class v1, Landroidx/datastore/preferences/protobuf/UInt32Value;

    monitor-enter v1

    .line 229
    :try_start_0
    sget-object v2, Landroidx/datastore/preferences/protobuf/UInt32Value;->PARSER:Landroidx/datastore/preferences/protobuf/Parser;

    move-object v0, v2

    .line 230
    if-nez v0, :cond_0

    .line 231
    new-instance v2, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser;

    sget-object v3, Landroidx/datastore/preferences/protobuf/UInt32Value;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/UInt32Value;

    invoke-direct {v2, v3}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser;-><init>(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;)V

    move-object v0, v2

    .line 234
    sput-object v0, Landroidx/datastore/preferences/protobuf/UInt32Value;->PARSER:Landroidx/datastore/preferences/protobuf/Parser;

    .line 236
    :cond_0
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v2

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .line 238
    :cond_1
    :goto_0
    return-object v0

    .line 223
    .end local v0    # "parser":Landroidx/datastore/preferences/protobuf/Parser;, "Landroidx/datastore/preferences/protobuf/Parser<Landroidx/datastore/preferences/protobuf/UInt32Value;>;"
    :pswitch_3
    sget-object v0, Landroidx/datastore/preferences/protobuf/UInt32Value;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/UInt32Value;

    return-object v0

    .line 214
    :pswitch_4
    const-string/jumbo v0, "value_"

    filled-new-array {v0}, [Ljava/lang/Object;

    move-result-object v0

    .line 217
    .local v0, "objects":[Ljava/lang/Object;
    const-string v1, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b"

    .line 219
    .local v1, "info":Ljava/lang/String;
    sget-object v2, Landroidx/datastore/preferences/protobuf/UInt32Value;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/UInt32Value;

    invoke-static {v2, v1, v0}, Landroidx/datastore/preferences/protobuf/UInt32Value;->newMessageInfo(Landroidx/datastore/preferences/protobuf/MessageLite;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    return-object v2

    .line 211
    .end local v0    # "objects":[Ljava/lang/Object;
    .end local v1    # "info":Ljava/lang/String;
    :pswitch_5
    new-instance v0, Landroidx/datastore/preferences/protobuf/UInt32Value$Builder;

    invoke-direct {v0, v1}, Landroidx/datastore/preferences/protobuf/UInt32Value$Builder;-><init>(Landroidx/datastore/preferences/protobuf/UInt32Value$1;)V

    return-object v0

    .line 208
    :pswitch_6
    new-instance v0, Landroidx/datastore/preferences/protobuf/UInt32Value;

    invoke-direct {v0}, Landroidx/datastore/preferences/protobuf/UInt32Value;-><init>()V

    return-object v0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public getValue()I
    .locals 1

    .line 33
    iget v0, p0, Landroidx/datastore/preferences/protobuf/UInt32Value;->value_:I

    return v0
.end method
