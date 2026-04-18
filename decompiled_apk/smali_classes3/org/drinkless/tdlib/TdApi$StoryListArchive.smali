.class public Lorg/drinkless/tdlib/TdApi$StoryListArchive;
.super Lorg/drinkless/tdlib/TdApi$StoryList;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryListArchive"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x27f58bf


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 7002
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryList;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 7007
    const v0, -0x27f58bf

    return v0
.end method
