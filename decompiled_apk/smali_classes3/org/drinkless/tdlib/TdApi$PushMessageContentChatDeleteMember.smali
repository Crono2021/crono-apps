.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentChatDeleteMember;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentChatDeleteMember"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x23afa99f


# instance fields
.field public isCurrentUser:Z

.field public isLeft:Z

.field public memberName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39206
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 39207
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ZZ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z
    .param p3, "z9"    # Z

    .line 39195
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 39196
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentChatDeleteMember;->memberName:Ljava/lang/String;

    .line 39197
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentChatDeleteMember;->isCurrentUser:Z

    .line 39198
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentChatDeleteMember;->isLeft:Z

    .line 39199
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39203
    const v0, 0x23afa99f

    return v0
.end method
