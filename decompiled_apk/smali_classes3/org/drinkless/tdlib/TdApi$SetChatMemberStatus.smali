.class public Lorg/drinkless/tdlib/TdApi$SetChatMemberStatus;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetChatMemberStatus"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4e0171f


# instance fields
.field public chatId:J

.field public memberId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public status:Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40240
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40241
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$MessageSender;Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p4, "chatMemberStatus"    # Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;

    .line 40229
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40230
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetChatMemberStatus;->chatId:J

    .line 40231
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SetChatMemberStatus;->memberId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 40232
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SetChatMemberStatus;->status:Lorg/drinkless/tdlib/TdApi$ChatMemberStatus;

    .line 40233
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40237
    const v0, 0x4e0171f

    return v0
.end method
