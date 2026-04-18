.class public Lorg/drinkless/tdlib/TdApi$InputStoryAreaTypePreviousVenue;
.super Lorg/drinkless/tdlib/TdApi$InputStoryAreaType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputStoryAreaTypePreviousVenue"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6e124e0c


# instance fields
.field public venueId:Ljava/lang/String;

.field public venueProvider:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27524
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputStoryAreaType;-><init>()V

    .line 27525
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 27514
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputStoryAreaType;-><init>()V

    .line 27515
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputStoryAreaTypePreviousVenue;->venueProvider:Ljava/lang/String;

    .line 27516
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputStoryAreaTypePreviousVenue;->venueId:Ljava/lang/String;

    .line 27517
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27521
    const v0, 0x6e124e0c

    return v0
.end method
