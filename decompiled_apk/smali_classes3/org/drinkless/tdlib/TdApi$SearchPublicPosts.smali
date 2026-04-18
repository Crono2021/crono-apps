.class public Lorg/drinkless/tdlib/TdApi$SearchPublicPosts;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchPublicPosts"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$FoundPublicPosts;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x24d7f763


# instance fields
.field public limit:I

.field public offset:Ljava/lang/String;

.field public query:Ljava/lang/String;

.field public starCount:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45030
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45031
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;IJ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "i9"    # I
    .param p4, "j5"    # J

    .line 45018
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45019
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SearchPublicPosts;->query:Ljava/lang/String;

    .line 45020
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SearchPublicPosts;->offset:Ljava/lang/String;

    .line 45021
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$SearchPublicPosts;->limit:I

    .line 45022
    iput-wide p4, p0, Lorg/drinkless/tdlib/TdApi$SearchPublicPosts;->starCount:J

    .line 45023
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45027
    const v0, 0x24d7f763

    return v0
.end method
