.class public Lorg/drinkless/tdlib/TdApi$LocationAddress;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LocationAddress"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5c252cde


# instance fields
.field public city:Ljava/lang/String;

.field public countryCode:Ljava/lang/String;

.field public state:Ljava/lang/String;

.field public street:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 44070
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44071
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "str3"    # Ljava/lang/String;
    .param p4, "str4"    # Ljava/lang/String;

    .line 44058
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 44059
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LocationAddress;->countryCode:Ljava/lang/String;

    .line 44060
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$LocationAddress;->state:Ljava/lang/String;

    .line 44061
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$LocationAddress;->city:Ljava/lang/String;

    .line 44062
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$LocationAddress;->street:Ljava/lang/String;

    .line 44063
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 44067
    const v0, -0x5c252cde

    return v0
.end method
