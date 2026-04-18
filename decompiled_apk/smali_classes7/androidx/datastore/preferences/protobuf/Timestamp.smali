.class public final Landroidx/datastore/preferences/protobuf/Timestamp;
.super Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;
.source "Timestamp.java"

# interfaces
.implements Landroidx/datastore/preferences/protobuf/TimestampOrBuilder;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/datastore/preferences/protobuf/Timestamp$Builder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroidx/datastore/preferences/protobuf/GeneratedMessageLite<",
        "Landroidx/datastore/preferences/protobuf/Timestamp;",
        "Landroidx/datastore/preferences/protobuf/Timestamp$Builder;",
        ">;",
        "Landroidx/datastore/preferences/protobuf/TimestampOrBuilder;"
    }
.end annotation


# static fields
.field private static final DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Timestamp;

.field public static final NANOS_FIELD_NUMBER:I = 0x2

.field private static volatile PARSER:Landroidx/datastore/preferences/protobuf/Parser; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/datastore/preferences/protobuf/Parser<",
            "Landroidx/datastore/preferences/protobuf/Timestamp;",
            ">;"
        }
    .end annotation
.end field

.field public static final SECONDS_FIELD_NUMBER:I = 0x1


# instance fields
.field private nanos_:I

.field private seconds_:J


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 482
    new-instance v0, Landroidx/datastore/preferences/protobuf/Timestamp;

    invoke-direct {v0}, Landroidx/datastore/preferences/protobuf/Timestamp;-><init>()V

    .line 485
    .local v0, "defaultInstance":Landroidx/datastore/preferences/protobuf/Timestamp;
    sput-object v0, Landroidx/datastore/preferences/protobuf/Timestamp;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Timestamp;

    .line 486
    const-class v1, Landroidx/datastore/preferences/protobuf/Timestamp;

    invoke-static {v1, v0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->registerDefaultInstance(Ljava/lang/Class;Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;)V

    .line 488
    .end local v0    # "defaultInstance":Landroidx/datastore/preferences/protobuf/Timestamp;
    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .line 78
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;-><init>()V

    .line 79
    return-void
.end method

.method static synthetic access$000()Landroidx/datastore/preferences/protobuf/Timestamp;
    .locals 1

    .line 73
    sget-object v0, Landroidx/datastore/preferences/protobuf/Timestamp;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Timestamp;

    return-object v0
.end method

.method static synthetic access$100(Landroidx/datastore/preferences/protobuf/Timestamp;J)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Timestamp;
    .param p1, "x1"    # J

    .line 73
    invoke-direct {p0, p1, p2}, Landroidx/datastore/preferences/protobuf/Timestamp;->setSeconds(J)V

    return-void
.end method

.method static synthetic access$200(Landroidx/datastore/preferences/protobuf/Timestamp;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Timestamp;

    .line 73
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Timestamp;->clearSeconds()V

    return-void
.end method

.method static synthetic access$300(Landroidx/datastore/preferences/protobuf/Timestamp;I)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Timestamp;
    .param p1, "x1"    # I

    .line 73
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Timestamp;->setNanos(I)V

    return-void
.end method

.method static synthetic access$400(Landroidx/datastore/preferences/protobuf/Timestamp;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Timestamp;

    .line 73
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Timestamp;->clearNanos()V

    return-void
.end method

.method private clearNanos()V
    .locals 1

    .line 168
    const/4 v0, 0x0

    iput v0, p0, Landroidx/datastore/preferences/protobuf/Timestamp;->nanos_:I

    .line 169
    return-void
.end method

.method private clearSeconds()V
    .locals 2

    .line 121
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Landroidx/datastore/preferences/protobuf/Timestamp;->seconds_:J

    .line 122
    return-void
.end method

.method public static getDefaultInstance()Landroidx/datastore/preferences/protobuf/Timestamp;
    .locals 1

    .line 491
    sget-object v0, Landroidx/datastore/preferences/protobuf/Timestamp;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Timestamp;

    return-object v0
.end method

.method public static newBuilder()Landroidx/datastore/preferences/protobuf/Timestamp$Builder;
    .locals 1

    .line 246
    sget-object v0, Landroidx/datastore/preferences/protobuf/Timestamp;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Timestamp;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Timestamp;->createBuilder()Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Timestamp$Builder;

    return-object v0
.end method

.method public static newBuilder(Landroidx/datastore/preferences/protobuf/Timestamp;)Landroidx/datastore/preferences/protobuf/Timestamp$Builder;
    .locals 1
    .param p0, "prototype"    # Landroidx/datastore/preferences/protobuf/Timestamp;

    .line 249
    sget-object v0, Landroidx/datastore/preferences/protobuf/Timestamp;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Timestamp;

    invoke-virtual {v0, p0}, Landroidx/datastore/preferences/protobuf/Timestamp;->createBuilder(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Timestamp$Builder;

    return-object v0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;)Landroidx/datastore/preferences/protobuf/Timestamp;
    .locals 1
    .param p0, "input"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 223
    sget-object v0, Landroidx/datastore/preferences/protobuf/Timestamp;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Timestamp;

    invoke-static {v0, p0}, Landroidx/datastore/preferences/protobuf/Timestamp;->parseDelimitedFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Ljava/io/InputStream;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Timestamp;

    return-object v0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/Timestamp;
    .locals 1
    .param p0, "input"    # Ljava/io/InputStream;
    .param p1, "extensionRegistry"    # Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 229
    sget-object v0, Landroidx/datastore/preferences/protobuf/Timestamp;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Timestamp;

    invoke-static {v0, p0, p1}, Landroidx/datastore/preferences/protobuf/Timestamp;->parseDelimitedFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Ljava/io/InputStream;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Timestamp;

    return-object v0
.end method

.method public static parseFrom(Landroidx/datastore/preferences/protobuf/ByteString;)Landroidx/datastore/preferences/protobuf/Timestamp;
    .locals 1
    .param p0, "data"    # Landroidx/datastore/preferences/protobuf/ByteString;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/datastore/preferences/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 187
    sget-object v0, Landroidx/datastore/preferences/protobuf/Timestamp;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Timestamp;

    invoke-static {v0, p0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Landroidx/datastore/preferences/protobuf/ByteString;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Timestamp;

    return-object v0
.end method

.method public static parseFrom(Landroidx/datastore/preferences/protobuf/ByteString;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/Timestamp;
    .locals 1
    .param p0, "data"    # Landroidx/datastore/preferences/protobuf/ByteString;
    .param p1, "extensionRegistry"    # Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/datastore/preferences/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 194
    sget-object v0, Landroidx/datastore/preferences/protobuf/Timestamp;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Timestamp;

    invoke-static {v0, p0, p1}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Landroidx/datastore/preferences/protobuf/ByteString;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Timestamp;

    return-object v0
.end method

.method public static parseFrom(Landroidx/datastore/preferences/protobuf/CodedInputStream;)Landroidx/datastore/preferences/protobuf/Timestamp;
    .locals 1
    .param p0, "input"    # Landroidx/datastore/preferences/protobuf/CodedInputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 234
    sget-object v0, Landroidx/datastore/preferences/protobuf/Timestamp;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Timestamp;

    invoke-static {v0, p0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Landroidx/datastore/preferences/protobuf/CodedInputStream;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Timestamp;

    return-object v0
.end method

.method public static parseFrom(Landroidx/datastore/preferences/protobuf/CodedInputStream;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/Timestamp;
    .locals 1
    .param p0, "input"    # Landroidx/datastore/preferences/protobuf/CodedInputStream;
    .param p1, "extensionRegistry"    # Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 241
    sget-object v0, Landroidx/datastore/preferences/protobuf/Timestamp;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Timestamp;

    invoke-static {v0, p0, p1}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Landroidx/datastore/preferences/protobuf/CodedInputStream;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Timestamp;

    return-object v0
.end method

.method public static parseFrom(Ljava/io/InputStream;)Landroidx/datastore/preferences/protobuf/Timestamp;
    .locals 1
    .param p0, "input"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 211
    sget-object v0, Landroidx/datastore/preferences/protobuf/Timestamp;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Timestamp;

    invoke-static {v0, p0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Ljava/io/InputStream;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Timestamp;

    return-object v0
.end method

.method public static parseFrom(Ljava/io/InputStream;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/Timestamp;
    .locals 1
    .param p0, "input"    # Ljava/io/InputStream;
    .param p1, "extensionRegistry"    # Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 218
    sget-object v0, Landroidx/datastore/preferences/protobuf/Timestamp;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Timestamp;

    invoke-static {v0, p0, p1}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Ljava/io/InputStream;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Timestamp;

    return-object v0
.end method

.method public static parseFrom(Ljava/nio/ByteBuffer;)Landroidx/datastore/preferences/protobuf/Timestamp;
    .locals 1
    .param p0, "data"    # Ljava/nio/ByteBuffer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/datastore/preferences/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 174
    sget-object v0, Landroidx/datastore/preferences/protobuf/Timestamp;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Timestamp;

    invoke-static {v0, p0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Ljava/nio/ByteBuffer;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Timestamp;

    return-object v0
.end method

.method public static parseFrom(Ljava/nio/ByteBuffer;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/Timestamp;
    .locals 1
    .param p0, "data"    # Ljava/nio/ByteBuffer;
    .param p1, "extensionRegistry"    # Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/datastore/preferences/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 181
    sget-object v0, Landroidx/datastore/preferences/protobuf/Timestamp;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Timestamp;

    invoke-static {v0, p0, p1}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Ljava/nio/ByteBuffer;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Timestamp;

    return-object v0
.end method

.method public static parseFrom([B)Landroidx/datastore/preferences/protobuf/Timestamp;
    .locals 1
    .param p0, "data"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/datastore/preferences/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 199
    sget-object v0, Landroidx/datastore/preferences/protobuf/Timestamp;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Timestamp;

    invoke-static {v0, p0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;[B)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Timestamp;

    return-object v0
.end method

.method public static parseFrom([BLandroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/Timestamp;
    .locals 1
    .param p0, "data"    # [B
    .param p1, "extensionRegistry"    # Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/datastore/preferences/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 206
    sget-object v0, Landroidx/datastore/preferences/protobuf/Timestamp;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Timestamp;

    invoke-static {v0, p0, p1}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;[BLandroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Timestamp;

    return-object v0
.end method

.method public static parser()Landroidx/datastore/preferences/protobuf/Parser;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroidx/datastore/preferences/protobuf/Parser<",
            "Landroidx/datastore/preferences/protobuf/Timestamp;",
            ">;"
        }
    .end annotation

    .line 497
    sget-object v0, Landroidx/datastore/preferences/protobuf/Timestamp;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Timestamp;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Timestamp;->getParserForType()Landroidx/datastore/preferences/protobuf/Parser;

    move-result-object v0

    return-object v0
.end method

.method private setNanos(I)V
    .locals 0
    .param p1, "value"    # I

    .line 154
    iput p1, p0, Landroidx/datastore/preferences/protobuf/Timestamp;->nanos_:I

    .line 155
    return-void
.end method

.method private setSeconds(J)V
    .locals 0
    .param p1, "value"    # J

    .line 108
    iput-wide p1, p0, Landroidx/datastore/preferences/protobuf/Timestamp;->seconds_:J

    .line 109
    return-void
.end method


# virtual methods
.method protected final dynamicMethod(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$MethodToInvoke;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 4
    .param p1, "method"    # Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$MethodToInvoke;
    .param p2, "arg0"    # Ljava/lang/Object;
    .param p3, "arg1"    # Ljava/lang/Object;

    .line 432
    sget-object v0, Landroidx/datastore/preferences/protobuf/Timestamp$1;->$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke:[I

    invoke-virtual {p1}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$MethodToInvoke;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x0

    packed-switch v0, :pswitch_data_0

    .line 475
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0

    .line 472
    :pswitch_0
    return-object v1

    .line 469
    :pswitch_1
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v0

    return-object v0

    .line 454
    :pswitch_2
    sget-object v0, Landroidx/datastore/preferences/protobuf/Timestamp;->PARSER:Landroidx/datastore/preferences/protobuf/Parser;

    .line 455
    .local v0, "parser":Landroidx/datastore/preferences/protobuf/Parser;, "Landroidx/datastore/preferences/protobuf/Parser<Landroidx/datastore/preferences/protobuf/Timestamp;>;"
    if-nez v0, :cond_1

    .line 456
    const-class v1, Landroidx/datastore/preferences/protobuf/Timestamp;

    monitor-enter v1

    .line 457
    :try_start_0
    sget-object v2, Landroidx/datastore/preferences/protobuf/Timestamp;->PARSER:Landroidx/datastore/preferences/protobuf/Parser;

    move-object v0, v2

    .line 458
    if-nez v0, :cond_0

    .line 459
    new-instance v2, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser;

    sget-object v3, Landroidx/datastore/preferences/protobuf/Timestamp;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Timestamp;

    invoke-direct {v2, v3}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser;-><init>(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;)V

    move-object v0, v2

    .line 462
    sput-object v0, Landroidx/datastore/preferences/protobuf/Timestamp;->PARSER:Landroidx/datastore/preferences/protobuf/Parser;

    .line 464
    :cond_0
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v2

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .line 466
    :cond_1
    :goto_0
    return-object v0

    .line 451
    .end local v0    # "parser":Landroidx/datastore/preferences/protobuf/Parser;, "Landroidx/datastore/preferences/protobuf/Parser<Landroidx/datastore/preferences/protobuf/Timestamp;>;"
    :pswitch_3
    sget-object v0, Landroidx/datastore/preferences/protobuf/Timestamp;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Timestamp;

    return-object v0

    .line 440
    :pswitch_4
    const-string/jumbo v0, "seconds_"

    const-string/jumbo v1, "nanos_"

    filled-new-array {v0, v1}, [Ljava/lang/Object;

    move-result-object v0

    .line 444
    .local v0, "objects":[Ljava/lang/Object;
    const-string v1, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004"

    .line 447
    .local v1, "info":Ljava/lang/String;
    sget-object v2, Landroidx/datastore/preferences/protobuf/Timestamp;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Timestamp;

    invoke-static {v2, v1, v0}, Landroidx/datastore/preferences/protobuf/Timestamp;->newMessageInfo(Landroidx/datastore/preferences/protobuf/MessageLite;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    return-object v2

    .line 437
    .end local v0    # "objects":[Ljava/lang/Object;
    .end local v1    # "info":Ljava/lang/String;
    :pswitch_5
    new-instance v0, Landroidx/datastore/preferences/protobuf/Timestamp$Builder;

    invoke-direct {v0, v1}, Landroidx/datastore/preferences/protobuf/Timestamp$Builder;-><init>(Landroidx/datastore/preferences/protobuf/Timestamp$1;)V

    return-object v0

    .line 434
    :pswitch_6
    new-instance v0, Landroidx/datastore/preferences/protobuf/Timestamp;

    invoke-direct {v0}, Landroidx/datastore/preferences/protobuf/Timestamp;-><init>()V

    return-object v0

    nop

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

.method public getNanos()I
    .locals 1

    .line 139
    iget v0, p0, Landroidx/datastore/preferences/protobuf/Timestamp;->nanos_:I

    return v0
.end method

.method public getSeconds()J
    .locals 2

    .line 94
    iget-wide v0, p0, Landroidx/datastore/preferences/protobuf/Timestamp;->seconds_:J

    return-wide v0
.end method
