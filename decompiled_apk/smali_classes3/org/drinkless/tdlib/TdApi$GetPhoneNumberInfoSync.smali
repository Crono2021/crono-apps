.class public Lorg/drinkless/tdlib/TdApi$GetPhoneNumberInfoSync;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetPhoneNumberInfoSync"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$PhoneNumberInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x209b7d38


# instance fields
.field public languageCode:Ljava/lang/String;

.field public phoneNumberPrefix:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26584
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26585
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;

    .line 26574
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 26575
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GetPhoneNumberInfoSync;->languageCode:Ljava/lang/String;

    .line 26576
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GetPhoneNumberInfoSync;->phoneNumberPrefix:Ljava/lang/String;

    .line 26577
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26581
    const v0, 0x209b7d38

    return v0
.end method
