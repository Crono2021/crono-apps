.class public Lorg/drinkless/tdlib/TdApi$SetVideoChatDefaultParticipant;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetVideoChatDefaultParticipant"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xe598d4d


# instance fields
.field public chatId:J

.field public defaultParticipantId:Lorg/drinkless/tdlib/TdApi$MessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32228
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 32229
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$MessageSender;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 32218
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 32219
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetVideoChatDefaultParticipant;->chatId:J

    .line 32220
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetVideoChatDefaultParticipant;->defaultParticipantId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 32221
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32225
    const v0, -0xe598d4d

    return v0
.end method
