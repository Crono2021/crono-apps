.class public Lorg/drinkless/tdlib/TdApi$MessageVideoChatEnded;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageVideoChatEnded"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x79262c57


# instance fields
.field public duration:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16926
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16927
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 16917
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16918
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$MessageVideoChatEnded;->duration:I

    .line 16919
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16923
    const v0, 0x79262c57

    return v0
.end method
