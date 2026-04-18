.class public Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ForumTopicInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7456e53c


# instance fields
.field public chatId:J

.field public creationDate:I

.field public creatorId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public forumTopicId:I

.field public icon:Lorg/drinkless/tdlib/TdApi$ForumTopicIcon;

.field public isClosed:Z

.field public isGeneral:Z

.field public isHidden:Z

.field public isNameImplicit:Z

.field public isOutgoing:Z

.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 53640
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53641
    return-void
.end method

.method public constructor <init>(JILjava/lang/String;Lorg/drinkless/tdlib/TdApi$ForumTopicIcon;ILorg/drinkless/tdlib/TdApi$MessageSender;ZZZZZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "str"    # Ljava/lang/String;
    .param p5, "forumTopicIcon"    # Lorg/drinkless/tdlib/TdApi$ForumTopicIcon;
    .param p6, "i10"    # I
    .param p7, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p8, "z8"    # Z
    .param p9, "z9"    # Z
    .param p10, "z10"    # Z
    .param p11, "z11"    # Z
    .param p12, "z12"    # Z

    .line 53621
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 53622
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;->chatId:J

    .line 53623
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;->forumTopicId:I

    .line 53624
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;->name:Ljava/lang/String;

    .line 53625
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;->icon:Lorg/drinkless/tdlib/TdApi$ForumTopicIcon;

    .line 53626
    iput p6, p0, Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;->creationDate:I

    .line 53627
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;->creatorId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 53628
    iput-boolean p8, p0, Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;->isGeneral:Z

    .line 53629
    iput-boolean p9, p0, Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;->isOutgoing:Z

    .line 53630
    iput-boolean p10, p0, Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;->isClosed:Z

    .line 53631
    iput-boolean p11, p0, Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;->isHidden:Z

    .line 53632
    iput-boolean p12, p0, Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;->isNameImplicit:Z

    .line 53633
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 53637
    const v0, -0x7456e53c

    return v0
.end method
