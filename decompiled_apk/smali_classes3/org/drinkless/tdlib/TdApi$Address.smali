.class public Lorg/drinkless/tdlib/TdApi$Address;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Address"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x79cfb0c6


# instance fields
.field public city:Ljava/lang/String;

.field public countryCode:Ljava/lang/String;

.field public postalCode:Ljava/lang/String;

.field public state:Ljava/lang/String;

.field public streetLine1:Ljava/lang/String;

.field public streetLine2:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49310
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49311
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;
    .param p4, "str4"    # Ljava/lang/String;
    .param p5, "str5"    # Ljava/lang/String;
    .param p6, "str6"    # Ljava/lang/String;

    .line 49296
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 49297
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$Address;->countryCode:Ljava/lang/String;

    .line 49298
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$Address;->state:Ljava/lang/String;

    .line 49299
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$Address;->city:Ljava/lang/String;

    .line 49300
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$Address;->streetLine1:Ljava/lang/String;

    .line 49301
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$Address;->streetLine2:Ljava/lang/String;

    .line 49302
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$Address;->postalCode:Ljava/lang/String;

    .line 49303
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49307
    const v0, -0x79cfb0c6

    return v0
.end method
