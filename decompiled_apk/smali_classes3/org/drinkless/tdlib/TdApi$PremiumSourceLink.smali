.class public Lorg/drinkless/tdlib/TdApi$PremiumSourceLink;
.super Lorg/drinkless/tdlib/TdApi$PremiumSource;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PremiumSourceLink"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7f42999c


# instance fields
.field public referrer:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17898
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PremiumSource;-><init>()V

    .line 17899
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 17889
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PremiumSource;-><init>()V

    .line 17890
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PremiumSourceLink;->referrer:Ljava/lang/String;

    .line 17891
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17895
    const v0, 0x7f42999c

    return v0
.end method
