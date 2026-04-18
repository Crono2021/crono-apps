.class public Lorg/drinkless/tdlib/TdApi$SendPhoneNumberCode;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SendPhoneNumberCode"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$AuthenticationCodeInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x409e3d10


# instance fields
.field public phoneNumber:Ljava/lang/String;

.field public settings:Lorg/drinkless/tdlib/TdApi$PhoneNumberAuthenticationSettings;

.field public type:Lorg/drinkless/tdlib/TdApi$PhoneNumberCodeType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39954
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39955
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$PhoneNumberAuthenticationSettings;Lorg/drinkless/tdlib/TdApi$PhoneNumberCodeType;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "phoneNumberAuthenticationSettings"    # Lorg/drinkless/tdlib/TdApi$PhoneNumberAuthenticationSettings;
    .param p3, "phoneNumberCodeType"    # Lorg/drinkless/tdlib/TdApi$PhoneNumberCodeType;

    .line 39943
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39944
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SendPhoneNumberCode;->phoneNumber:Ljava/lang/String;

    .line 39945
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SendPhoneNumberCode;->settings:Lorg/drinkless/tdlib/TdApi$PhoneNumberAuthenticationSettings;

    .line 39946
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SendPhoneNumberCode;->type:Lorg/drinkless/tdlib/TdApi$PhoneNumberCodeType;

    .line 39947
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39951
    const v0, 0x409e3d10

    return v0
.end method
