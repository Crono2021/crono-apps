.class public Lorg/drinkless/tdlib/TdApi$UpdateMessageSendFailed;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateMessageSendFailed"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x25e40719


# instance fields
.field public error:Lorg/drinkless/tdlib/TdApi$Error;

.field public message:Lorg/drinkless/tdlib/TdApi$Message;

.field public oldMessageId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41802
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41803
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Message;JLorg/drinkless/tdlib/TdApi$Error;)V
    .locals 0
    .param p1, "message"    # Lorg/drinkless/tdlib/TdApi$Message;
    .param p2, "j5"    # J
    .param p4, "error"    # Lorg/drinkless/tdlib/TdApi$Error;

    .line 41791
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41792
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageSendFailed;->message:Lorg/drinkless/tdlib/TdApi$Message;

    .line 41793
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageSendFailed;->oldMessageId:J

    .line 41794
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageSendFailed;->error:Lorg/drinkless/tdlib/TdApi$Error;

    .line 41795
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41799
    const v0, -0x25e40719

    return v0
.end method
