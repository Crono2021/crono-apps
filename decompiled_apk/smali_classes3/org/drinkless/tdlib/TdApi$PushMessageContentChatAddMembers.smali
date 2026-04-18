.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentChatAddMembers;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentChatAddMembers"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x40cc84c6


# instance fields
.field public isCurrentUser:Z

.field public isReturned:Z

.field public memberName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39184
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 39185
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ZZ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z
    .param p3, "z9"    # Z

    .line 39173
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 39174
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentChatAddMembers;->memberName:Ljava/lang/String;

    .line 39175
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentChatAddMembers;->isCurrentUser:Z

    .line 39176
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentChatAddMembers;->isReturned:Z

    .line 39177
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39181
    const v0, -0x40cc84c6

    return v0
.end method
