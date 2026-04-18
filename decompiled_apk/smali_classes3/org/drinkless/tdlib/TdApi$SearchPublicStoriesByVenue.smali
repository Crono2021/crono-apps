.class public Lorg/drinkless/tdlib/TdApi$SearchPublicStoriesByVenue;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchPublicStoriesByVenue"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$FoundStories;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x28e59dd6


# instance fields
.field public limit:I

.field public offset:Ljava/lang/String;

.field public venueId:Ljava/lang/String;

.field public venueProvider:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45078
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45079
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;
    .param p4, "i9"    # I

    .line 45066
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 45067
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SearchPublicStoriesByVenue;->venueProvider:Ljava/lang/String;

    .line 45068
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SearchPublicStoriesByVenue;->venueId:Ljava/lang/String;

    .line 45069
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SearchPublicStoriesByVenue;->offset:Ljava/lang/String;

    .line 45070
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$SearchPublicStoriesByVenue;->limit:I

    .line 45071
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45075
    const v0, -0x28e59dd6

    return v0
.end method
