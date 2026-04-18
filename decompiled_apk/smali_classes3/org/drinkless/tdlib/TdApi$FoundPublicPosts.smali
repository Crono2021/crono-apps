.class public Lorg/drinkless/tdlib/TdApi$FoundPublicPosts;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FoundPublicPosts"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4964e0e4


# instance fields
.field public areLimitsExceeded:Z

.field public messages:[Lorg/drinkless/tdlib/TdApi$Message;

.field public nextOffset:Ljava/lang/String;

.field public searchLimits:Lorg/drinkless/tdlib/TdApi$PublicPostSearchLimits;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 43278
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 43279
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$Message;Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$PublicPostSearchLimits;Z)V
    .locals 0
    .param p1, "messageArr"    # [Lorg/drinkless/tdlib/TdApi$Message;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "publicPostSearchLimits"    # Lorg/drinkless/tdlib/TdApi$PublicPostSearchLimits;
    .param p4, "z8"    # Z

    .line 43266
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 43267
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$FoundPublicPosts;->messages:[Lorg/drinkless/tdlib/TdApi$Message;

    .line 43268
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$FoundPublicPosts;->nextOffset:Ljava/lang/String;

    .line 43269
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$FoundPublicPosts;->searchLimits:Lorg/drinkless/tdlib/TdApi$PublicPostSearchLimits;

    .line 43270
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$FoundPublicPosts;->areLimitsExceeded:Z

    .line 43271
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 43275
    const v0, 0x4964e0e4    # 937486.25f

    return v0
.end method
