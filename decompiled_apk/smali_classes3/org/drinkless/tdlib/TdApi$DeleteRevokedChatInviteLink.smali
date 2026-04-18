.class public Lorg/drinkless/tdlib/TdApi$DeleteRevokedChatInviteLink;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteRevokedChatInviteLink"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6ed8f381


# instance fields
.field public chatId:J

.field public inviteLink:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25164
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25165
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;

    .line 25154
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25155
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteRevokedChatInviteLink;->chatId:J

    .line 25156
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$DeleteRevokedChatInviteLink;->inviteLink:Ljava/lang/String;

    .line 25157
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25161
    const v0, -0x6ed8f381

    return v0
.end method
