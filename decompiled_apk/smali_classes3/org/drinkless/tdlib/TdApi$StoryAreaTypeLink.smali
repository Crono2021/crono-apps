.class public Lorg/drinkless/tdlib/TdApi$StoryAreaTypeLink;
.super Lorg/drinkless/tdlib/TdApi$StoryAreaType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryAreaTypeLink"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x79d9e7b


# instance fields
.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20364
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryAreaType;-><init>()V

    .line 20365
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 20355
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryAreaType;-><init>()V

    .line 20356
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StoryAreaTypeLink;->url:Ljava/lang/String;

    .line 20357
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20361
    const v0, -0x79d9e7b

    return v0
.end method
