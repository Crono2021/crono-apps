.class public Lorg/drinkless/tdlib/TdApi$InputStoryAreaTypeLink;
.super Lorg/drinkless/tdlib/TdApi$InputStoryAreaType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputStoryAreaTypeLink"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x53f31b48


# instance fields
.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15162
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputStoryAreaType;-><init>()V

    .line 15163
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 15153
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputStoryAreaType;-><init>()V

    .line 15154
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputStoryAreaTypeLink;->url:Ljava/lang/String;

    .line 15155
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15159
    const v0, 0x53f31b48

    return v0
.end method
