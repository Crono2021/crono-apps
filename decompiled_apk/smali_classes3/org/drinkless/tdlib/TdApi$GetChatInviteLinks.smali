.class public Lorg/drinkless/tdlib/TdApi$GetChatInviteLinks;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetChatInviteLinks"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ChatInviteLinks;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x34a55cac


# instance fields
.field public chatId:J

.field public creatorUserId:J

.field public isRevoked:Z

.field public limit:I

.field public offsetDate:I

.field public offsetInviteLink:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49814
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49815
    return-void
.end method

.method public constructor <init>(JJZILjava/lang/String;I)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "z8"    # Z
    .param p6, "i9"    # I
    .param p7, "str"    # Ljava/lang/String;
    .param p8, "i10"    # I

    .line 49800
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49801
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetChatInviteLinks;->chatId:J

    .line 49802
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$GetChatInviteLinks;->creatorUserId:J

    .line 49803
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$GetChatInviteLinks;->isRevoked:Z

    .line 49804
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$GetChatInviteLinks;->offsetDate:I

    .line 49805
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$GetChatInviteLinks;->offsetInviteLink:Ljava/lang/String;

    .line 49806
    iput p8, p0, Lorg/drinkless/tdlib/TdApi$GetChatInviteLinks;->limit:I

    .line 49807
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49811
    const v0, 0x34a55cac

    return v0
.end method
