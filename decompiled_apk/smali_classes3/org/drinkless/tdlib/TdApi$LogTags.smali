.class public Lorg/drinkless/tdlib/TdApi$LogTags;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LogTags"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5fa94c29


# instance fields
.field public tags:[Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16170
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 16171
    return-void
.end method

.method public constructor <init>([Ljava/lang/String;)V
    .locals 0
    .param p1, "strArr"    # [Ljava/lang/String;

    .line 16161
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 16162
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LogTags;->tags:[Ljava/lang/String;

    .line 16163
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16167
    const v0, -0x5fa94c29

    return v0
.end method
