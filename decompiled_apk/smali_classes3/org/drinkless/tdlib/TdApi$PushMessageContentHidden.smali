.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentHidden;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentHidden"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x12e447a4


# instance fields
.field public isPinned:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18132
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 18133
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 18123
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 18124
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentHidden;->isPinned:Z

    .line 18125
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18129
    const v0, -0x12e447a4

    return v0
.end method
