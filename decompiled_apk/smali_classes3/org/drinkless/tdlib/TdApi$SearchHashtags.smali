.class public Lorg/drinkless/tdlib/TdApi$SearchHashtags;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SearchHashtags"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Hashtags;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3e34a571


# instance fields
.field public limit:I

.field public prefix:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30628
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30629
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "i9"    # I

    .line 30618
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 30619
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SearchHashtags;->prefix:Ljava/lang/String;

    .line 30620
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$SearchHashtags;->limit:I

    .line 30621
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30625
    const v0, 0x3e34a571

    return v0
.end method
