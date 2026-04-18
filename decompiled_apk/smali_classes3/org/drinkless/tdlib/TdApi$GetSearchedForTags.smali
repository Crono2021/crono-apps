.class public Lorg/drinkless/tdlib/TdApi$GetSearchedForTags;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetSearchedForTags"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Hashtags;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x64e4cf33


# instance fields
.field public limit:I

.field public tagPrefix:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26684
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26685
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "i9"    # I

    .line 26674
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26675
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetSearchedForTags;->tagPrefix:Ljava/lang/String;

    .line 26676
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$GetSearchedForTags;->limit:I

    .line 26677
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26681
    const v0, -0x64e4cf33

    return v0
.end method
