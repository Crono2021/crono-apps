.class public Lorg/drinkless/tdlib/TdApi$StoryAreaTypeWeather;
.super Lorg/drinkless/tdlib/TdApi$StoryAreaType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryAreaTypeWeather"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x59a78242


# instance fields
.field public backgroundColor:I

.field public emoji:Ljava/lang/String;

.field public temperature:D


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40922
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryAreaType;-><init>()V

    .line 40923
    return-void
.end method

.method public constructor <init>(DLjava/lang/String;I)V
    .locals 0
    .param p1, "d9"    # D
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "i9"    # I

    .line 40911
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryAreaType;-><init>()V

    .line 40912
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$StoryAreaTypeWeather;->temperature:D

    .line 40913
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$StoryAreaTypeWeather;->emoji:Ljava/lang/String;

    .line 40914
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$StoryAreaTypeWeather;->backgroundColor:I

    .line 40915
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40919
    const v0, -0x59a78242

    return v0
.end method
