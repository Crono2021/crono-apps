.class public Lorg/drinkless/tdlib/TdApi$CreateChatInviteLink;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CreateChatInviteLink"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ChatInviteLink;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1126a341


# instance fields
.field public chatId:J

.field public createsJoinRequest:Z

.field public expirationDate:I

.field public memberLimit:I

.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46916
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 46917
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;IIZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "i9"    # I
    .param p5, "i10"    # I
    .param p6, "z8"    # Z

    .line 46903
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 46904
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$CreateChatInviteLink;->chatId:J

    .line 46905
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$CreateChatInviteLink;->name:Ljava/lang/String;

    .line 46906
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$CreateChatInviteLink;->expirationDate:I

    .line 46907
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$CreateChatInviteLink;->memberLimit:I

    .line 46908
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$CreateChatInviteLink;->createsJoinRequest:Z

    .line 46909
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46913
    const v0, 0x1126a341

    return v0
.end method
