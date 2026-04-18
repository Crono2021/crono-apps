.class public Lorg/drinkless/tdlib/TdApi$MessageChatAddMembers;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageChatAddMembers"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6564ffd4


# instance fields
.field public memberUserIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16242
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16243
    return-void
.end method

.method public constructor <init>([J)V
    .locals 0
    .param p1, "jArr"    # [J

    .line 16233
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16234
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageChatAddMembers;->memberUserIds:[J

    .line 16235
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16239
    const v0, 0x6564ffd4

    return v0
.end method
