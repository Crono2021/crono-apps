.class public Lorg/drinkless/tdlib/TdApi$SendBusinessMessageAlbum;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SendBusinessMessageAlbum"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$BusinessMessages;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2f01356e


# instance fields
.field public businessConnectionId:Ljava/lang/String;

.field public chatId:J

.field public disableNotification:Z

.field public effectId:J

.field public inputMessageContents:[Lorg/drinkless/tdlib/TdApi$InputMessageContent;

.field public protectContent:Z

.field public replyTo:Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51734
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 51735
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;JLorg/drinkless/tdlib/TdApi$InputMessageReplyTo;ZZJ[Lorg/drinkless/tdlib/TdApi$InputMessageContent;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "j5"    # J
    .param p4, "inputMessageReplyTo"    # Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;
    .param p5, "z8"    # Z
    .param p6, "z9"    # Z
    .param p7, "j9"    # J
    .param p9, "inputMessageContentArr"    # [Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 51719
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 51720
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SendBusinessMessageAlbum;->businessConnectionId:Ljava/lang/String;

    .line 51721
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$SendBusinessMessageAlbum;->chatId:J

    .line 51722
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SendBusinessMessageAlbum;->replyTo:Lorg/drinkless/tdlib/TdApi$InputMessageReplyTo;

    .line 51723
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$SendBusinessMessageAlbum;->disableNotification:Z

    .line 51724
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$SendBusinessMessageAlbum;->protectContent:Z

    .line 51725
    iput-wide p7, p0, Lorg/drinkless/tdlib/TdApi$SendBusinessMessageAlbum;->effectId:J

    .line 51726
    iput-object p9, p0, Lorg/drinkless/tdlib/TdApi$SendBusinessMessageAlbum;->inputMessageContents:[Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 51727
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51731
    const v0, 0x2f01356e

    return v0
.end method
