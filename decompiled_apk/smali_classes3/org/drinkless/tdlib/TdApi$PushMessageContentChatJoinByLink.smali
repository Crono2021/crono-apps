.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentChatJoinByLink;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentChatJoinByLink"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5c9bdf49


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 5630
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 5635
    const v0, 0x5c9bdf49

    return v0
.end method
