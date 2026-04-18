.class public Lorg/drinkless/tdlib/TdApi$EditChatInviteLink;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditChatInviteLink"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ChatInviteLink;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4eb23d7c


# instance fields
.field public chatId:J

.field public createsJoinRequest:Z

.field public expirationDate:I

.field public inviteLink:Ljava/lang/String;

.field public memberLimit:I

.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49674
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49675
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;IIZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "str2"    # Ljava/lang/String;
    .param p5, "i9"    # I
    .param p6, "i10"    # I
    .param p7, "z8"    # Z

    .line 49660
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49661
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$EditChatInviteLink;->chatId:J

    .line 49662
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$EditChatInviteLink;->inviteLink:Ljava/lang/String;

    .line 49663
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$EditChatInviteLink;->name:Ljava/lang/String;

    .line 49664
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$EditChatInviteLink;->expirationDate:I

    .line 49665
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$EditChatInviteLink;->memberLimit:I

    .line 49666
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$EditChatInviteLink;->createsJoinRequest:Z

    .line 49667
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49671
    const v0, 0x4eb23d7c

    return v0
.end method
