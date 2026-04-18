.class public Lorg/drinkless/tdlib/TdApi$BlockListStories;
.super Lorg/drinkless/tdlib/TdApi$BlockList;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BlockListStories"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x628965c


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 258
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$BlockList;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 263
    const v0, 0x628965c

    return v0
.end method
